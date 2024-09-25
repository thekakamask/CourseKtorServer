package com.example.dao

import com.example.Constants
import com.example.exception.CourseException
import com.example.model.Course
import com.example.model.Error

object CourseDao {

    //Mutable list of courses
    private val courses = mutableListOf(
        Course(1, "How to troll a Troll?", 6, true),
        Course(2, "Kotlin for Trolls", 1, true),
        Course(3, "How to not use Java?", 3, false),
        Course(4, "Use Kotlin", 2, true),
        Course(5, "How to smile?", 2, true),
        Course(6, "Kotlin for noobs", 1, true),
        Course(7, "How to use Java?", 3, false),
        Course(8, "Advanced Kotlin Patterns", 4, true),
        Course(9, "Java Memory Management", 3, false),
        Course(10, "Mastering Coroutines", 5, true),
        Course(11, "Dependency Injection with Hilt", 4, true),
        Course(12, "Building REST APIs with Ktor", 5, true),
        Course(13, "Compose UI Basics", 2, true),
        Course(14, "Debugging in Android Studio", 3, true),
        Course(15, "Secure Coding in Kotlin", 4, true),
        Course(16, "Multithreading in Java", 3, false),
        Course(17, "Introduction to Gradle", 1, true)
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

//CourseDao is the interface that simulates an in-memory database. It contains a
// mutable list of courses and methods for :
// Retrieve the course with the highest level via getTopCourse().
//Recover a course according to its id via getCourseSafely(id) or
// getCourse(id) with exception handling if the course doesn't exist.