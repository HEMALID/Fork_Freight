package com.example.fork_freight_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.ModelRole.role
import com.example.fork_freight_app.ModelRole.roleX
import com.example.fork_freight_app.databinding.RoleItemBinding

class RoleAdapter(val context: Context, var roleList: List<roleX>) :RecyclerView.Adapter<RoleAdapter.ViewHolder>(){

    /*fun setDataList(data :  ArrayList<roleX>) {
        this.roleList = data
    }*/

    class ViewHolder(val binding: RoleItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data: roleX) {
            binding.recyclerData = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RoleItemBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(roleList[position])
    }

    override fun getItemCount(): Int {
        return roleList.size
    }
}