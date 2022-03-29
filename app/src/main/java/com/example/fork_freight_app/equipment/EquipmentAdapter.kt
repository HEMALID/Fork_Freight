package com.example.fork_freight_app.equipment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.databinding.EquipmentItemBinding

class EquipmentAdapter(var datax : List<String>):RecyclerView.Adapter<EquipmentAdapter.ViewHolder>() {

    class ViewHolder(val binding: EquipmentItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent  : ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EquipmentItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datax[position])
    }

    override fun getItemCount(): Int {
        return datax.size
    }
}