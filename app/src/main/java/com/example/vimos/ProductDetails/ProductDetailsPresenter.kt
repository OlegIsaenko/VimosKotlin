package com.example.vimos.ProductDetails

import com.example.vimos.Model.Product

class ProductDetailsPresenter(private val detailsView: ProductDetailsView) {

    fun showProductDetails(product: Product) {
        detailsView.showProductDetails(product)
    }
}
