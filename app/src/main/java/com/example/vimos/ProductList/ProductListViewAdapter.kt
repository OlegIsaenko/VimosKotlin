package com.example.vimos.ProductList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.example.vimos.ApiService.Options
import com.example.vimos.Model.Product
import com.example.vimos.R
import com.jakewharton.rxbinding3.view.clicks
import java.util.Locale

class ProductListViewAdapter(private val values: List<Product>?, private val listener: ProductListView) : RecyclerView.Adapter<ProductListViewAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_product_holder, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.price.text = String.format(Locale.getDefault(), "%d", values?.get(position)?.price)
        holder.gCode.text = String.format("%s", values?.get(position)?.gcode)
        holder.name.text = values?.get(position)?.name
        Glide.with(holder.view)
                .load(String.format("%1\$s%2\$s", Options.BASE_URL_FOR_IMAGE, values?.get(position)?.imgPreview))
                .into(holder.image)

        holder.view.clicks().subscribe({ v -> listener.showProductDetails(values?.get(position)) })
    }

    override fun getItemCount(): Int {
        return values?.size!!
    }


    class ProductHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var image: ImageView
        var name: TextView
        var price: TextView
        var gCode: TextView

        init {
            image = view.findViewById(R.id.product_image)
            name = view.findViewById(R.id.product_name)
            price = view.findViewById(R.id.product_price)
            gCode = view.findViewById(R.id.product_gcode)
        }
    }
}