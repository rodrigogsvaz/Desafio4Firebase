package android.example.com.desafio4_firebase.adapter

import android.content.Context
import android.content.Intent
import android.example.com.desafio4_firebase.R
import android.example.com.desafio4_firebase.entities.Game
import android.example.com.desafio4_firebase.ui.GameinfoActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.squareup.picasso.Picasso


class GameAdapter (private val games: MutableList<Game>,
                       var ctx: Context) : RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    class ViewHolder  (item: View) : RecyclerView.ViewHolder(item){

        val tv_name: TextView = item.findViewById(R.id.tv_game_name)
        val tv_year:TextView = item.findViewById(R.id.tv_game_year)
        val img_game: ImageView = item.findViewById(R.id.game_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(ctx).inflate(R.layout.item_games, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = games[position]
        holder.itemView.tag = position
        holder.tv_year.setText(itemView.year.toString())
        holder.tv_name.setText(itemView.name)

        holder.itemView.setOnClickListener {
            var intent = Intent(ctx, GameinfoActivity::class.java)
            var item = games[position]
            intent.putExtra("game", item)
            ctx.startActivity(intent)
        }

        Glide.with(ctx)
            .load(itemView.photo)
            .placeholder(R.drawable.semfoto)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(holder.img_game)


    }
    override fun getItemCount() = games.size
}