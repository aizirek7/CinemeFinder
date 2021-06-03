package com.example.cinemafinder.ui.main.adapter

import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.R
import com.example.cinemafinder.model.Movie

class Adapter(
    var context: Context?,
    var boolean: Boolean,
    var movies: List<Movie>,
    var listener: OnItemClickListener
) : RecyclerView.Adapter<Adapter.MovieHolder>() {
    lateinit var view: View

    inner class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.goodTitleNow)
        var date: TextView = itemView.findViewById(R.id.goodDateNow)
        var rate: TextView = itemView.findViewById(R.id.goodRateNow)
        var movie: ImageView = itemView.findViewById(R.id.goodImageNow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.itemView.apply {
            holder.title.text = movies[position].title
            holder.date.text = movies[position].date
            holder.movie.setImageResource(movies[position].image)
            holder.rate.setText(movies[position].rate)

        }
    }
}

interface OnItemClickListener {
    fun onItemClick(position: Int)
}


