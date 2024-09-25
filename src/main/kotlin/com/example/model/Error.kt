package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Error (val status: Int, val errorMessage: String)

//Represents an error object with a status code and a message, returned
//when something goes wrong.