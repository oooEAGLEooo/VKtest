package com.example.testvk.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testvk.Model.Product
import com.example.testvk.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MyProductAdapter(private val context: Context,private val productList: MutableList<Product>):RecyclerView.Adapter<MyProductAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val thumbnail: ImageView = itemView.thumbnail
        val title: TextView = itemView.title
        val description: TextView = itemView.description

        fun bind(listItem: Product) {
            thumbnail.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.thumbnail}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemView.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.title.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = productList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = productList[position]
        holder.bind(listItem)

        Picasso.get().load(productList[position].thumbnail).into(holder.thumbnail)
        holder.title.text = productList[position].title
        holder.description.text = productList[position].description
    }

}