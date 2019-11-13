package com.example.vimos.ApiService

import com.example.vimos.Model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("products")
    fun getProductList(
        @Query("cat_id") catId: Int,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("base_id") baseId: Int,
        @Query("sort_type") sortType: Int
    ): Call<List<Product>>

}