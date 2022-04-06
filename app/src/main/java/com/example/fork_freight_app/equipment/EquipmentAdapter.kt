package com.example.fork_freight_app.equipment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fork_freight_app.databinding.EquipmentItemBinding


class EquipmentAdapter(var datax: List<String>) : RecyclerView.Adapter<EquipmentAdapter.viewHolder>() {

    class viewHolder(val binding: EquipmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.data = data

        }

        /*private var isChecked = false
        fun getChecked(): Boolean {
            return isChecked
        }
        fun setChecked(checked: Boolean) {
            isChecked = checked
        }*/
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

  /*  internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {
        private var mCheckedTextView: CheckedTextView = itemView.findViewById<View>(R.id.switch1) as CheckedTextView
        fun bind(position: Int) {
            mCheckedTextView.isChecked = !!itemStateArray.get(position, false)
            mCheckedTextView.setText(java.lang.String.valueOf(items.get(position).getPosition()))
        }

        override fun onClick(v: View) {
            val adapterPosition = adapterPosition
            if (!itemStateArray.get(adapterPosition, false)) {
                mCheckedTextView.isChecked = true
                itemStateArray.put(adapterPosition, true)
            } else {
                mCheckedTextView.isChecked = false
                itemStateArray.put(adapterPosition, false)
            }
        }

        init {
            itemView.setOnClickListener(this)
        }
    }*/
}