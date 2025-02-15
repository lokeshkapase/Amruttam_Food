package com.lokesh.amruttam_food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

    class SeasonAdapter(private val seasons: List<String>, private val onClick: (String) -> Unit) : RecyclerView.Adapter<SeasonAdapter.SeasonViewHolder>() {

        inner class SeasonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val btnSeason: Button = itemView.findViewById(R.id.btnSeason)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_season, parent, false)
            return SeasonViewHolder(view)
        }

        override fun onBindViewHolder(holder: SeasonViewHolder, position: Int) {
            val season = seasons[position]
            holder.btnSeason.text = season
            holder.btnSeason.setOnClickListener {
                onClick(season)
                notifyDataSetChanged()
            }
            holder.btnSeason.isSelected = position == selectedPosition
        }

        override fun getItemCount(): Int {
            return seasons.size
        }

        private var selectedPosition = 0

        fun setSelectedPosition(position: Int) {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }
