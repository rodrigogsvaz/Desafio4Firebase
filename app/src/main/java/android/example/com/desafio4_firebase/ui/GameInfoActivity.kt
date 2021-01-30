package android.example.com.desafio4_firebase.ui

import android.content.Intent
import android.example.com.desafio4_firebase.R
import android.example.com.desafio4_firebase.entities.Game
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GameinfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_info)

        val bundle: Bundle? = intent.extras
        val game = bundle?.getSerializable("game") as? Game

        val image : ImageView = findViewById(R.id.game_image)
        val title: TextView = findViewById(R.id.tv_game_name_detailed)
        val subtitle: TextView = findViewById(R.id.tv_game_name)
        val year: TextView = findViewById(R.id.tv_game_year)
        val description: TextView = findViewById(R.id.tv_game_description)
        val bt_back : ImageButton = findViewById(R.id.bt_back)

        val floating : FloatingActionButton = findViewById(R.id.editgame)

        Glide.with(this)
            .load(game!!.photo)
            .placeholder(R.drawable.semfoto)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(image)

        title.text=game.name
        subtitle.text=game.name
        year.text=game.year.toString()
        description.text = game.description

        floating.setOnClickListener {
            var intent = Intent(this, GameRegisterActivity()::class.java)
            var item = game
            intent.putExtra("game", item)
            startActivity(intent)
        }

        bt_back.setOnClickListener {
            finish()
        }
    }
}