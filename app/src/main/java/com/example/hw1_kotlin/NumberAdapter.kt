package com.example.hw1_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(private var count: Int) :
        RecyclerView.Adapter<NumberAdapter.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.numberText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val colorRes = if (position % 2 == 0) R.color.item_even_red else R.color.item_odd_blue
        holder.text.text = position.toString()
        holder.text.setBackgroundColor(ContextCompat.getColor(holder.text.context, colorRes))
    }

    override fun getItemCount() = count

    fun addItem() {
        count++
        notifyItemInserted(count - 1)
    }

    fun getCount() = count
}