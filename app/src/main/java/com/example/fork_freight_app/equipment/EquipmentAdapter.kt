package com.example.fork_freight_app.equipment

import android.annotation.SuppressLint
import android.graphics.ColorSpace.Model
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.R
import com.example.fork_freight_app.databinding.EquipmentItemBinding
import com.example.fork_freight_app.equipment.modelequipment.Modelx

class EquipmentAdapter(var datax: List<String>) : RecyclerView.Adapter<EquipmentAdapter.viewHolder>() {

    private var items: List<Modelx> = ArrayList()
    var itemStateArray = SparseBooleanArray()
    fun EquipmentAdapter() {}

    class viewHolder(val binding: EquipmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var itemStateArray = SparseBooleanArray()

        fun bind(data: String) {
            binding.data = data

        }

        private var isChecked = false
        fun getChecked(): Boolean {
            return isChecked
        }
        fun setChecked(checked: Boolean) {
            isChecked = checked
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = EquipmentItemBinding.inflate(layoutInflater)
        return viewHolder(binding)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.bind(datax[position])
    }

    override fun getItemCount(): Int {
        return datax.size
    }

    init {
        setHasStableIds(true)
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        var itemStateArray = SparseBooleanArray()
        private var items: List<Modelx> = ArrayList()

        private var mChecked: SwitchCompat = itemView.findViewById<View>(R.id.switch1) as SwitchCompat

        fun bind(position: Int) {

            mChecked.isChecked = itemStateArray.get(position, false)
            mChecked.setText(java.lang.String.valueOf(items.get(position).getPosition()))
        }

        override fun onClick(v: View) {
            val adapterPosition = adapterPosition
            if (!itemStateArray.get(adapterPosition, false)) {
                mChecked.isChecked = true
                itemStateArray.put(adapterPosition, true)
            } else {
                mChecked.isChecked = false
                itemStateArray.put(adapterPosition, false)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }
    }
}