package com.example.vimos.ApiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var retrofit: Retrofit? = null

    val client: Retrofit?
    get() {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Options.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}