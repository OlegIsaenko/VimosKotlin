package com.example.vimos.ApiService

import java.io.Serializable

class Options(
    var catId: Int,
    var limit: Int,
    var offset: Int,
    var baseId: Int,
    var sortType: Int) : Serializable {
    companion object {
        val BASE_URL = "http://vimos.ru:1455/"
        val BASE_URL_FOR_IMAGE = "http://vimos.ru"
    }
}
