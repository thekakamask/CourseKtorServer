package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Course (val id: Int, val title: String, val lvl: Int, val isActive: Boolean )

//Represents a course with properties such as id, title, lvl, and isActive.