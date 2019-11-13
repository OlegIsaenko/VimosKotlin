package com.example.vimos.ProductList

import com.example.vimos.Model.Product

interface ProductListView {

    fun showProgress()

    fun hideProgress()

    fun showProductList(productList: List<Product>?)

    fun showMessage(message: String)

    fun showProductDetails(product: Product?)

}
