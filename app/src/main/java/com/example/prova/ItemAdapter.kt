package com.example.prova

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter (private val list: List<ItemViewModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageview: ImageView = itemView.findViewById(R.id.home_item_imageview)
        val textview: TextView = itemView.findViewById(R.id.home_item_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]

        holder.textview.text = item.itemName
        Picasso.get().load(item.itemImageUrl).into(holder.imageview)

        holder.itemView.setOnClickListener {
            manageOnClick(holder.itemView.context, item)
        }
    }
    private fun manageOnClick(context: Context, item: ItemViewModel) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("name", item.itemName)
        intent.putExtra("url", item.itemImageUrl)
        intent.putExtra("details", item.itemDetail)

        context.startActivity(intent)
        (context as Activity).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }

}