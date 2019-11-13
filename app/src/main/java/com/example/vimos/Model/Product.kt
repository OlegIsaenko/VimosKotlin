package com.example.vimos.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Product : Serializable {

    @SerializedName("gcode")
    @Expose
    var gcode: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("old_price")
    @Expose
    var oldPrice: Int? = null
    @SerializedName("new")
    @Expose
    var new: Int? = null
    @SerializedName("has_discount")
    @Expose
    var hasDiscount: Int? = null
    @SerializedName("is_stocked")
    @Expose
    var isStocked: Int? = null
    @SerializedName("prior")
    @Expose
    var prior: Int? = null
    @SerializedName("cat_id")
    @Expose
    var catId: Int? = null
    @SerializedName("img_preview")
    @Expose
    var imgPreview: String? = null


    override fun toString(): String {
        return "$name, $gcode, $price"
    }
}