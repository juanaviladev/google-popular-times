package dev.juanavila.populartimes.infrastructure

import com.google.gson.GsonBuilder
import com.google.gson.JsonArray

val gson = GsonBuilder()
    .create()

internal fun String.asJsonArray(): JsonArray? {
    return gson.fromJson(this, JsonArray::class.java)
}