package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.*

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}

//Monitoring lets you record and log HTTP calls. With the
// CallLogging plugin, every request whose path begins with / will be logged with a
// INFO logging level. This makes it possible to track incoming requests for
// debugging or performance analysis.