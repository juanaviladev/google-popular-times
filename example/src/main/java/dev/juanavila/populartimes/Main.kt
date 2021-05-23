package dev.juanavila.populartimes

import dev.juanavila.populartimes.domain.Query
import dev.juanavila.populartimes.domain.SearchEngineRegion
import java.util.*

fun main() {
    val englishPopularTimes = GooglePopularTimes.Builder(SearchEngineRegion.USA)
        .withLocale(Locale.ENGLISH)
        .build()

    println(
        englishPopularTimes.search(
            Query("Prado museum in Madrid")
        )
    )

    println(
        englishPopularTimes.search(
            Query("Query without results")
        )
    )

    val spanishPopularTimes = GooglePopularTimes.Builder(SearchEngineRegion.ES)
        .withLocale(Locale("es"))
        .build()

    println(
        spanishPopularTimes.search(
            Query("Prado museum in Madrid")
        )
    )

    println(
        spanishPopularTimes.search(
            Query("Query without results")
        )
    )
}