package com.lokesh.amruttam_food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val itemList: List<Product>) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.itemImage)
        val itemName: TextView = view.findViewById(R.id.itemName)
        val itemWeight: TextView = view.findViewById(R.id.itemWeight)
        val itemPrice: TextView = view.findViewById(R.id.itemPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.itemImage.setImageResource(item.itemImage)
        holder.itemName.text = item.itemName
        holder.itemWeight.text = item.itemWeight
        holder.itemPrice.text = item.itemPrice
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
