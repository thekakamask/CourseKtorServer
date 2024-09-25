package com.example.dao

import com.example.Constants
import com.example.exception.CourseException
import com.example.model.Course
import com.example.model.Error

//Le CourseDao est l'interface qui simule une base de données en mémoire. Il contient une
// liste mutable de cours et des méthodes pour :
//Récupérer le cours avec le plus haut niveau via getTopCourse().
//Récupérer un cours en fonction de son id via getCourseSafely(id) ou
// getCourse(id) avec gestion d'exception si le cours n'existe pas.

object CourseDao {

    //Mutable list of courses
    private val courses = mutableListOf(
        Course(1, "How to troll a Troll?", 5, true),
        Course(2, "Kotlin for Trolls", 1, true),
        Course(3, "How to not use Java?", 3, false)
    )

    // Recover course with the higher lvl
    fun getTopCourse(): Course? {
        return courses.maxByOrNull { it.lvl }
    }

    /*fun getCourse(courseId: Int) =
        try {
            get(courseId)
        } catch (e: CourseException) {
            Error(404, Constants.ERROR_COURSE_NOT_FOUND)
        }*/

    fun getCourseSafely(courseId: Int): Any {
        return try {
            getCourse(courseId)  // Call to function how survey exception
        } catch (e: CourseException) {
            Error(404, Constants.ERROR_COURSE_NOT_FOUND)  // Send back Error object in case of exception
        }
    }

    // Recover course by ID
    private fun getCourse(courseId: Int): Course {
        return courses.find { it.id == courseId }
            ?: throw CourseException()  // Survey an exception if the course is not find
    }

    // Recover course by ID
    /*fun getCourse(courseId: Int): Course {
        return courses.find { it.id == courseId }
            ?: throw CourseException()  // Survey an exception if the course is not find
    }*/

}