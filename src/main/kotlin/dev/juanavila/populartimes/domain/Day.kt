package dev.juanavila.populartimes.domain

data class Day(var status: Status, var hours: List<Hour>)

enum class Status { OPEN, CLOSED }