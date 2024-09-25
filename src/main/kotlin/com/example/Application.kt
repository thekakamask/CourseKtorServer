package com.example

import com.example.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}

//Main server :
//-main: This is the main function that launches the Ktor server. It uses the Netty
// engine to start the server, with the configurations defined in application.conf
// or as a command line argument.
//-Application.module() : This function is called at server startup.
// It configures the various server modules, such as monitoring,
// Serialization, and Routing.
