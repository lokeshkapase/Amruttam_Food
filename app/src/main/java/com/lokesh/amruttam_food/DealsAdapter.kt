package com.lokesh.amruttam_food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class DealsAdapter(private val dealsList: List<Int>) :
    RecyclerView.Adapter<DealsAdapter.DealViewHolder>() {

    inner class DealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dealImage: ImageView = view.findViewById(R.id.dealImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_deal, parent, false)
        return DealViewHolder(view)
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        holder.dealImage.setImageResource(dealsList[position])
    }

    override fun getItemCount(): Int {
        return dealsList.size
    }
}

