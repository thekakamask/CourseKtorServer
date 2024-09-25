package com.example

import com.example.plugins.*
import io.ktor.server.application.*

//Serveur principal :
//main : C'est la fonction principale qui lance le serveur Ktor. Elle utilise le moteur Netty
// pour démarrer le serveur, avec les configurations définies dans application.conf
// ou en argument de ligne de commande.
//Application.module() : Cette fonction est appelée lors du démarrage du serveur.
// Elle configure les différents modules du serveur comme la surveillance (Monitoring),
// la sérialisation (Serialization), et le routage (Routing).

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
