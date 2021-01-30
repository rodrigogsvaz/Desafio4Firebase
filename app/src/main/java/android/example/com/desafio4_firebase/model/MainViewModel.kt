package android.example.com.desafio4_firebase.model

import android.example.com.desafio4_firebase.entities.Game
import android.example.com.desafio4_firebase.entities.Storage
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel() : ViewModel (){
    var listGames = MutableLiveData<MutableList<Game>>()

    fun getListGames() {
        listGames = Storage(null).getInstances()
    }
}