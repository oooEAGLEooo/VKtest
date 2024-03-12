package com.example.testvk.Interface
import com.example.testvk.Model.Product
import retrofit2.Call
import retrofit2.http.*

interface ProductService {
    @GET("products")
    fun getProductList(): Call<MutableList<Product>>
}
