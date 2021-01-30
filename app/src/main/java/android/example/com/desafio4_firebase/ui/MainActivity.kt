package android.example.com.desafio4_firebase.ui

import android.app.Activity
import android.content.Intent
import android.example.com.desafio4_firebase.R
import android.example.com.desafio4_firebase.adapter.GameAdapter
import android.example.com.desafio4_firebase.model.MainViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {

    private lateinit var rc_view : RecyclerView

    val viewModel by viewModels<MainViewModel>{
        object : ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        var emptylist : TextView = findViewById(R.id.empty)

        viewModel.getListGames()

        rc_view = findViewById(R.id.rv_games)

        viewModel.listGames.observe(this) {
            //if (!it.isNullOrEmpty()) {
            rc_view.visibility = View.VISIBLE
            emptylist.visibility = View.INVISIBLE
            rc_view.adapter = GameAdapter(it, this)
            rc_view.layoutManager = GridLayoutManager(this, 2)
            rc_view.setHasFixedSize(true)
            //} else {
            //   rc_view.visibility = View.INVISIBLE
            //    emptylist.visibility = View.VISIBLE
            //}
        }
    }

    override fun onResume() {
        super.onResume()
        var emptylist : TextView = findViewById(R.id.empty)

        viewModel.getListGames()

        rc_view = findViewById(R.id.rv_games)

        viewModel.listGames.observe(this) {
            //if (!it.isNullOrEmpty()) {
            rc_view.visibility = View.VISIBLE
            emptylist.visibility = View.INVISIBLE
            rc_view.adapter = GameAdapter(it, this)
            rc_view.layoutManager = GridLayoutManager(this, 2)
            rc_view.setHasFixedSize(true)
            //} else {
            //   rc_view.visibility = View.INVISIBLE
            //    emptylist.visibility = View.VISIBLE
            //}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var emptylist : TextView = findViewById(R.id.empty)

        viewModel.getListGames()

        Log.i ("Lista completa", viewModel.listGames.toString())


        rc_view = findViewById(R.id.rv_games)

        viewModel.listGames.observe(this) {
            //if (!it.isNullOrEmpty()) {
            rc_view.visibility = View.VISIBLE
            emptylist.visibility = View.INVISIBLE
            rc_view.adapter = GameAdapter(it, this)
            rc_view.layoutManager = GridLayoutManager(this, 2)
            rc_view.setHasFixedSize(true)
            //} else {
            //   rc_view.visibility = View.INVISIBLE
            //    emptylist.visibility = View.VISIBLE
            //}
        }
        var floating : FloatingActionButton = findViewById(R.id.addgame)

        floating.setOnClickListener {
            startActivity(Intent(this, GameRegisterActivity()::class.java))
        }
    }


}