package com.example.vimos.ProductList

import com.example.vimos.ApiService.ApiService
import com.example.vimos.ApiService.RetrofitService
import com.example.vimos.Model.Product

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class ProductListPresenter(private val productListView: ProductListView) {

    private val apiService: ApiService?

    init {
        apiService = RetrofitService.client?.create(ApiService::class.java)
    }

    fun getProductListFromApi(catId: Int, limit: Int, offset: Int, baseId: Int, sortType: Int) {
        productListView.showProgress()
        apiService!!.getProductList(catId, limit, offset, baseId, sortType).enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if (response.isSuccessful) {
                    val products = response.body()
                    productListView.showProductList(products)
                    productListView.hideProgress()
                }
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                productListView.showMessage(t.toString())
                productListView.hideProgress()
            }
        })
    }
}
