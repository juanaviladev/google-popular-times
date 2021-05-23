package dev.juanavila.populartimes.infrastructure

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import dev.juanavila.populartimes.domain.*
import org.apache.commons.lang3.StringEscapeUtils
import java.util.*

internal class SearchResultsScraper(
    private val locale: Locale,
    private val googleSearcher: HttpGoogleSearcher,
    private val engineRegion: SearchEngineRegion
) : PopularTimesScraper {

    override fun search(query: Query): PopularTimesResult {
        val result = googleSearcher.search(engineRegion, query, locale)
        val popularTimesContainer = Regex("var $KEY_VARIABLE=(\\[.+);")
        val match = popularTimesContainer.find(result.text)
        return match
            ?.let(this::extractVariableContentFrom)
            ?.let(this::convertToJavaUnicode)
            ?.let(this::searchPopularTimes)
            ?.let(this::navigateToHoursContainer)
            ?.map(this::extractHours)
            ?.map(this::mapHours)
            ?.let(::PopularTimes)
            ?: NotFoundPopularTimes
    }

    private fun extractVariableContentFrom(it: MatchResult): String? {
        return it.groups[1]?.value
    }

    private fun convertToJavaUnicode(text: String): String {
        return text.replace("\\\\x".toRegex(), "\\\\u00")
    }

    private fun navigateToHoursContainer(parent: JsonArray): JsonArray {
        return extractFirstChildDownTo(level = 3, parent)
    }

    private fun extractFirstChildDownTo(level: Int, array: JsonArray): JsonArray {
        if (level == 0) return array
        return extractFirstChildDownTo(level - 1, array[0].asJsonArray)
    }

    private fun searchPopularTimes(json: String): JsonArray? {
        return json
            .asJsonArray()
            ?.firstOrNull(this::firstChildContainingWithStopwords)
            ?.let(this::unescapeContent)
            ?.asJsonArray()
            ?.let(this::extractPopularTimes)
    }

    private fun firstChildContainingWithStopwords(child: JsonElement): Boolean =
        child.asString.contains(stopwordsRegex())

    private fun extractPopularTimes(array: JsonArray?): JsonArray? =
        array?.get(1)?.asJsonArray

    private fun unescapeContent(element: JsonElement?): String? =
        element?.asString?.let(StringEscapeUtils::unescapeJava)

    private fun stopwordsRegex(): Regex {
        return "kc:/local:busyness".toRegex()
    }

    private fun extractHours(element: JsonElement): JsonArray {
        return element.asJsonArray[1].asJsonArray
    }

    private fun mapHours(dayData: JsonArray): Day {
        if (dayData[0].isJsonNull) return Day(Status.CLOSED, emptyList())

        val hours = dayData[0].asJsonArray

        return hours
            .map(JsonElement::getAsJsonArray)
            .map {
                val dayHours = it[1].asJsonArray
                Hour(it[0].asInt, dayHours[0].asInt, dayHours[3].asString)
            }
            .let { Day(Status.OPEN, it) }
    }

    companion object {
        val KEY_VARIABLE = "m"
    }
}