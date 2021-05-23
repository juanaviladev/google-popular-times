package dev.juanavila.populartimes

import dev.juanavila.populartimes.domain.PopularTimesResult
import dev.juanavila.populartimes.domain.PopularTimesScraper
import dev.juanavila.populartimes.domain.Query
import dev.juanavila.populartimes.domain.SearchEngineRegion
import dev.juanavila.populartimes.infrastructure.HttpGoogleSearcher
import dev.juanavila.populartimes.infrastructure.SearchResultsScraper
import java.util.*

class GooglePopularTimes internal constructor(
    private val popularTimesScraper: PopularTimesScraper
) {

    fun search(query: Query): PopularTimesResult = popularTimesScraper.search(query)

    class Builder(private var searchEngineRegion: SearchEngineRegion) {

        private var locale = Locale.ENGLISH
        private var usingNonDefaultScraper = false
        private lateinit var popularTimesScraper: PopularTimesScraper

        fun withLocale(locale: Locale): Builder {
            this.locale = locale
            return this
        }

        fun withPopularTimesScraper(popularTimesScraper: PopularTimesScraper): Builder {
            this.popularTimesScraper = popularTimesScraper
            this.usingNonDefaultScraper = true
            return this
        }

        fun build(): GooglePopularTimes {
            if (usingNonDefaultScraper) return GooglePopularTimes(popularTimesScraper)

            return GooglePopularTimes(
                SearchResultsScraper(
                    locale = locale,
                    googleSearcher = HttpGoogleSearcher(),
                    engineRegion = searchEngineRegion
                )
            )
        }
    }
}