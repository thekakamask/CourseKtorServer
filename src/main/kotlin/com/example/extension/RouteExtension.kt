package com.example.extension

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//Ces extensions définissent des façons pratiques d’ajouter des routes avec des paramètres.
// Elles permettent de définir des chemins GET en répondant avec un texte, un modèle converti
// en JSON, ou encore un modèle récupéré à partir d'un paramètre de la requête
// (par exemple, un id de cours).

/**
 * Builds a route to match `GET` requests with specified [path] showing specified [text]
 */

fun Route.get(path: String, text: String) = route(path) {
    get {
        call.respondText { text }
    }
}

/**
 * Builds a route to match `GET` requests with specified [path] showing specified [model] as a Json
 */
fun Route.get(path: String, model: Any?) = route(path) {
    get {
        if (model != null) {
            call.respond(model)  // Ktor utilise kotlinx.serialization pour convertir en JSON
        } else {
            call.respond(HttpStatusCode.NotFound, "No data found")
        }
    }
}

/**
 * Builds a route to match `GET` requests with specified [path] and specified param [param] showing specified [getModel] as a Json
 */
fun Route.get(path: String, param: String, getModel: (Int) -> Any) = route(path) {
    get {
        val courseId = call.parameters[param]?.toIntOrNull()
        if (courseId != null) {
            val model = getModel(courseId)
            call.respond(model)  // Ktor use kotlinx.serialization for JSON convert
        } else {
            call.respond(HttpStatusCode.BadRequest, "Invalid parameter")
        }
    }
}