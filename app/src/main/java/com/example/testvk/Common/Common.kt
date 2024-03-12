package com.example.testvk.Common
import com.example.testvk.Interface.ProductService
import com.example.testvk.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://dummyjson.com/"
    val retrofitService: ProductService
        get() = RetrofitClient.getClient(BASE_URL).create(ProductService::class.java)
}