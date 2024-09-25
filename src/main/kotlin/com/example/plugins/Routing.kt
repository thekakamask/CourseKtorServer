package com.example.plugins

import com.example.Constants
import com.example.dao.CourseDao
import com.example.extension.get
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        // Utilisation de la fonction d'extension pour la page d'accueil
        get("/", Constants.WELCOME_MESSAGE)

        // Utilisation de la fonction d'extension pour obtenir le top course
        get("/course/top", CourseDao.getTopCourse())

        // Utilisation de la fonction d'extension pour obtenir un cours spécifique par ID
        get("/course/{id}", "id") { id ->
            CourseDao.getCourseSafely(id)
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}

//routing defines the server's HTTP routes. The Ktor server has several routes that
// respond to GET requests:
// / : Returns a welcome message defined in Constants.WELCOME_MESSAGE.
// /course/top : Returns the course with the highest level using
// CourseDao.getTopCourse().
// /course/{id} : Returns a specific course identified by id using
// CourseDao.getCourseSafely(id).
