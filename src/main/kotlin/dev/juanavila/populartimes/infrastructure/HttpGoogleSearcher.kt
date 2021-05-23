package dev.juanavila.populartimes.infrastructure

import dev.juanavila.populartimes.domain.Query
import dev.juanavila.populartimes.domain.SearchEngineRegion
import dev.juanavila.populartimes.domain.SearchResult
import java.net.URL
import java.net.URLConnection
import java.net.URLEncoder.encode
import java.util.*

internal class HttpGoogleSearcher {

    fun search(region: SearchEngineRegion, query: Query, locale: Locale): SearchResult {
        return URL("https://www.google.${region.domainSuffix}/search?hl=${locale.language}&q=${encode(query.text)}")
            .openConnection()
            .apply(this::setFakeUserAgent)
            .apply(URLConnection::connect)
            .let(this::readAsText)
            .let(::SearchResult)
    }

    private fun setFakeUserAgent(conn: URLConnection) {
        conn.setRequestProperty(
            "User-Agent",
            "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36"
        )
    }

    private fun readAsText(conn: URLConnection): String {
        return conn
            .getInputStream()
            .bufferedReader()
            .readText()
    }
}