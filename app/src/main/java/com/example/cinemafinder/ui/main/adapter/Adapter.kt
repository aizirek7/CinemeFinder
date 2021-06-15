package com.example.cinemafinder.ui.main.adapter

import android.content.Context
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemafinder.R
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Result
import com.example.cinemafinder.data.Utils
import com.example.cinemafinder.databinding.ItemMovieBinding
import com.example.cinemafinder.ui.main.MainFragment
import com.example.cinemafinder.ui.main.MainViewModel

class Adapter(
    var context: Context?,
    var boolean: Boolean,
    var movies: List<Movie>,
    var listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.MovieHolder>() {
    lateinit var binding: ItemMovieBinding
    var number1: Int = 0
    var number2: Int = 0

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val title: TextView = itemView.findViewById(R.id.goodTitleNow)
        val rate: TextView = itemView.findViewById(R.id.goodRateNow)
        val image: ImageView = itemView.findViewById(R.id.goodImageNow)
        val date: TextView = itemView.findViewById(R.id.goodDateNow)
        private val parent: CardView = itemView.findViewById(R.id.cardView)

        init {
            parent.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition, movies)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        if (position == movies.size - 1) {
            if (!boolean) {
                MainViewModel().getMovie("ru-Ru", "popularity.desc", number1++)
            } else {
                MainViewModel().getMovie("ru-Ru", "vote_average.desc", number2++)
            }
        }

        holder.itemView.apply {
            holder.title.text = movies[position].original_title
            holder.date.text = movies[position].release_date
            holder.rate.text = movies[position].vote_average.toString()
            Glide.with(context).load(Utils.URL_IMAGE + movies[position].poster_path)
                .into(holder.image)
        }
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int, movies: List<Movie>)
}




