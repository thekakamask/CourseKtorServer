package com.example.model

import kotlinx.serialization.Serializable

//Représente un objet d'erreur avec un code d'état et un message, retourné
//lorsque quelque chose ne va pas.

@Serializable
data class Error (val status: Int, val errorMessage: String)