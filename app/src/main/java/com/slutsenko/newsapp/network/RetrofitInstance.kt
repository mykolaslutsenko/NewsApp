package com.slutsenko.newsapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  RetrofitInstance {

    val newsRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://188.40.167.45:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}