package com.example.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

// La sérialisation utilise Kotlinx Serialization pour gérer les données JSON dans les
// réponses et les requêtes HTTP. Elle est configurée pour formater le JSON de manière lisible,
// accepter des formats plus permissifs, et ignorer les champs inconnus lors
// de la désérialisation des données.

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
