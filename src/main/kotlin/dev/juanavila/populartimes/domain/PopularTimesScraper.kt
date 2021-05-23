package dev.juanavila.populartimes.domain

interface PopularTimesScraper {
    fun search(query: Query): PopularTimesResult
}

sealed class PopularTimesResult
data class PopularTimes(val days: List<Day>) : PopularTimesResult()
object NotFoundPopularTimes : PopularTimesResult() {
    override fun toString(): String = "No results"
}