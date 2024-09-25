package com.example.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true // for an exit JSON well formated
            isLenient = true   // accept JSON format more permissive
            ignoreUnknownKeys = true // Ignore unknown fields when deserializing
        })
    }
    /*routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }*/
}

// Serialization uses Kotlinx Serialization to handle JSON data in
// responses and HTTP requests. It is configured to format JSON in a readable way,
// accept more permissive formats, and ignore unknown fields when
// data deserialization.