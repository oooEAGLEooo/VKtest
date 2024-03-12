package com.example.testvk

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testvk.Adapter.MyProductAdapter
import com.example.testvk.Common.Common
import com.example.testvk.Interface.ProductService
import com.example.testvk.Model.Product
import com.example.testvk.R

//import d_max.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: ProductService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyProductAdapter
//    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerProductList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerProductList.layoutManager = layoutManager
        //dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllProductList()
    }

    private fun getAllProductList() {
//        dialog.show()
        mService.getProductList().enqueue(object : Callback<MutableList<Product>> {
            override fun onFailure(call: Call<MutableList<Product>>, t: Throwable) {

            }

            override fun onResponse(call: Call<MutableList<Product>>, response: Response<MutableList<Product>>) {
                adapter = MyProductAdapter(baseContext, response.body() as MutableList<Product>)
                adapter.notifyDataSetChanged()
                recyclerProductList.adapter = adapter

 //               dialog.dismiss()
            }
        })
    }
}