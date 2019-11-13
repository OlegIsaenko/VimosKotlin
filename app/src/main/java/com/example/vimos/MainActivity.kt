package com.example.vimos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.vimos.ApiService.Options
import com.example.vimos.ProductList.ProductListViewActivity
import com.jakewharton.rxbinding3.view.clicks

class MainActivity : AppCompatActivity() {

    private val queryParameters: Options
        get() = Options(catId, limit, offset, baseId, sortType)

    val catId: Int
        get() = 7

    val limit: Int
        get() = 10

    val offset: Int
        get() = 0

    val baseId: Int
        get() = 12

    val sortType: Int
        get() = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productListButton = findViewById<Button>(R.id.product_list_button)
        productListButton.clicks().subscribe({v -> getProductListWithOptions()})

    }

    private fun getProductListWithOptions() {
        val intent = Intent(this@MainActivity, ProductListViewActivity::class.java)
        val options = queryParameters
        intent.putExtra("options", options)
        startActivity(intent)
    }
}
