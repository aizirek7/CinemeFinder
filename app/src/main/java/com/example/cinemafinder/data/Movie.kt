package com.example.cinemafinder.data

import java.io.Serializable

data class Movie(
    val original_language: String,
    val original_title: String,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val vote_average: Double,
    val id: Int
): Serializable