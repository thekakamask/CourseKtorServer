package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.event.*

//Le monitoring permet d'enregistrer et de journaliser les appels HTTP. Avec le plugin
// CallLogging, chaque requête dont le chemin commence par / sera enregistrée avec un
// niveau de journalisation INFO. Cela permet de suivre les requêtes entrantes pour le
// débogage ou l'analyse des performances.

fun Application.configureMonitoring() {
    install(CallLogging) {
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }
}
