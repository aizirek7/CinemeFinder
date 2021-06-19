package com.example.cinemafinder.model

import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.MovieResponse
import retrofit2.Call
import retrofit2.Response

interface RepoImple {
    suspend fun getMovieWithRate(sort_by: String, page:Int): Response<MovieResponse>
    suspend fun getMovieWithoutRate(sort_by: String, page: Int): Response<MovieResponse>
}