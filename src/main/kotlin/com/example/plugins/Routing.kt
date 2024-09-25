package com.example.plugins

import com.example.Constants
import com.example.dao.CourseDao
import com.example.extension.get
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

//le routage défini les routes HTTP du serveur. Le serveur Ktor a plusieurs routes qui
// répondent aux requêtes GET :
//  / : Retourne un message de bienvenue défini dans Constants.WELCOME_MESSAGE.
//  /course/top : Retourne le cours ayant le niveau le plus élevé à l'aide de
//  CourseDao.getTopCourse().
//  /course/{id} : Retourne un cours spécifique identifié par un id grâce à
//  CourseDao.getCourseSafely(id).

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
