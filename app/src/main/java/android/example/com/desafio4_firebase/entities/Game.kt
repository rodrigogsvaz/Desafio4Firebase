package android.example.com.desafio4_firebase.entities

import java.io.Serializable

data class Game (var ID : String,
                 var name: String,
                 var year: Int,
                 var photo: String,
                 var description : String) : Serializable