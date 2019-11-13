package com.example.vimos.ProductDetails

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.vimos.ApiService.Options
import com.example.vimos.Model.Product
import com.example.vimos.R


class ProductDetailsActivity : AppCompatActivity(), ProductDetailsView {

    private var detailsPresenter: ProductDetailsPresenter? = null

    private var image: ImageView? = null
    private var name: TextView? = null
    private var price: TextView? = null
    private var gCode: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        name = findViewById(R.id.product_name)
        price = findViewById(R.id.details_price)
        gCode = findViewById(R.id.details_gcode)
        image = findViewById(R.id.details_image)

        if (detailsPresenter == null) {
            detailsPresenter = ProductDetailsPresenter(this)
        }

        val product = intent.getSerializableExtra("product") as Product
        detailsPresenter!!.showProductDetails(product)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showProductDetails(product: Product) {
        name!!.text = product.name
        price!!.text = String.format("%s", product.price)
        gCode!!.text = String.format("%s", product.gcode)
        Glide.with(this)
                .load(String.format("%1\$s%2\$s", Options.BASE_URL_FOR_IMAGE, product.imgPreview))
                .into(image!!)
    }
}
