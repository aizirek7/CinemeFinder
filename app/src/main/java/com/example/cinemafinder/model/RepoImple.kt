package com.example.cinemafinder.model

interface RepoImple {
    fun getMovieWithRate(): List<Movie>
    fun getMovieWithoutRate(): List<Movie>
}