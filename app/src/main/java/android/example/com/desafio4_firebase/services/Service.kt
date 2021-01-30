package android.example.com.desafio4_firebase.services

import com.google.firebase.firestore.FirebaseFirestore

var db = FirebaseFirestore.getInstance()
var cr = db.collection("Game")