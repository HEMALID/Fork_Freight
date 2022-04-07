package com.example.fork_freight_app.equipment.modelequipment

class Modelx {
    private var position = 0
    fun getPosition(): Int {
        return position
    }
    fun setPosition(position: Int) {
        this.position = position
    }

    private var isChecked = false
    fun getChecked(): Boolean {
        return isChecked
    }
    fun setChecked(checked: Boolean) {
        isChecked = checked
    }
}