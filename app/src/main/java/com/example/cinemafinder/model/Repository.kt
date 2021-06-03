package com.example.cinemafinder.model

import com.example.cinemafinder.R

class Repository: RepoImple {
    var movies = mutableListOf<Movie>()
    var movies2 = mutableListOf<Movie>()

    override fun getMovieWithRate(): List<Movie> {
        movies.add(Movie(R.drawable.amma, "Эмма", "2020", "6.7"))
        movies.add(Movie(R.drawable.kill, "Воспоминания об убийстве", "2020", "8.1"))
        movies.add(Movie(R.drawable.p, "Парфюмер", "2010", "6.7"))
        movies.add(Movie(R.drawable.t, "Обсласти тьмы", "2006", "9.8"))
        movies.add(Movie(R.drawable.v, "Веном", "2018", "8.1"))
        movies.add(Movie(R.drawable.vivv, "Вивариум", "2019", "5.7"))
        return movies
   }

    override fun getMovieWithoutRate(): List<Movie> {
        movies2.add(Movie(R.drawable.movie, "Айнбо сердце Амозонии", "12.06.2022"))
        movies2.add(Movie(R.drawable.ray, "Рая последний дракон", "22.07.2021"))
        movies2.add(Movie(R.drawable.sheck, "Шрек 5", "28.01.2021"))
        movies2.add(Movie(R.drawable.venom, "Веном 2", "31.09.2021"))
        return movies2
    }

}