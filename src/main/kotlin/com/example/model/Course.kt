package com.example.model

import kotlinx.serialization.Serializable

//Représente un cours avec des propriétés comme id, title, lvl, et isActive.

@Serializable
data class Course (val id: Int, val title: String, val lvl: Int, val isActive: Boolean )