package com.example.vimos.ProductList

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.vimos.ApiService.Options
import com.example.vimos.Model.Product
import com.example.vimos.ProductDetails.ProductDetailsActivity
import com.example.vimos.R

class ProductListViewActivity : AppCompatActivity(), ProductListView {


    private var listPresenter: ProductListPresenter? = null
    private var recyclerView: RecyclerView? = null
    private var options: Options? = null
    private var progressBarView: View? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        progressBarView = findViewById(R.id.progress_bar_layout)

        options = intent.getSerializableExtra("options") as Options

        if (listPresenter == null) {
            listPresenter = ProductListPresenter(this)
        }

        recyclerView = findViewById(R.id.product_list_recycler_view)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
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

    override fun onResume() {
        super.onResume()
        listPresenter!!.getProductListFromApi(
                options!!.catId,
                options!!.limit,
                options!!.offset,
                options!!.baseId,
                options!!.sortType
        )
    }

    override fun showProductList(productList: List<Product>?) {
        recyclerView!!.adapter = ProductListViewAdapter(productList, this)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showProductDetails(product: Product?) {
        getSelectedProductDetails(product)
    }

    private fun getSelectedProductDetails(product: Product?) {
        val intent = Intent(this@ProductListViewActivity, ProductDetailsActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }

    override fun showProgress() {
        progressBarView!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBarView!!.visibility = View.INVISIBLE
    }


}
