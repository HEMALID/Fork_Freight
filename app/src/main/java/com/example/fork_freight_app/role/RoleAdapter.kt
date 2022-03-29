package com.example.fork_freight_app.role

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.databinding.RoleItemBinding
import com.example.fork_freight_app.role.modelrole.Role

class RoleAdapter(var role : List<Role>) :RecyclerView.Adapter<RoleAdapter.ViewHolder>(){

    class ViewHolder(val binding: RoleItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: Role) {
            binding.role = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RoleItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(role[position])
    }

    override fun getItemCount(): Int {
        return role.size
    }

}