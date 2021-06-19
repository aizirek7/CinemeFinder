package com.example.cinemafinder.data

import com.example.cinemafinder.network.NetworkUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    fun get(): NetworkUtils {
        val retrofit =  Retrofit.Builder()
            .baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NetworkUtils::class.java)
    }
}
