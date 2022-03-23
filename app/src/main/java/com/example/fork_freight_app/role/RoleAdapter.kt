package com.example.fork_freight_app.role

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.databinding.RoleItemBinding
import com.example.fork_freight_app.role.modelrole.Role

class RoleAdapter() :RecyclerView.Adapter<RoleAdapter.ViewHolder>(){

    var role = ArrayList<Role>()

    fun setDataList(data:ArrayList<Role>){
        this.role = data
    }
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

    override fun getItemCount() = role.size

}