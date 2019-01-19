package com.revosleap.simpleadapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

class SimpleAdapter(private val layout: Int, private val callbacks: SimpleCallbacks): RecyclerView.Adapter<SimpleAdapter.ViewHolder>(){

    private val items = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(parent.inflate(layout), callbacks)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

//    This method appends items
//    to the existing list
    fun addManyItems(list: MutableList<Any>){
        items.addAll(list)
        notifyDataSetChanged()
    }
//    This method replaces the items
//    in the old list with the new ones

    fun changeItems(list: MutableList<Any>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int){
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun removeItem(item: Any){
        items.remove(item)
        notifyDataSetChanged()
    }

    fun clearItems(){
        items.clear()
        notifyDataSetChanged()
    }

    fun addItem(position: Int, item: Any){
        items.add(position, item)
        notifyItemInserted(position)
    }

    fun addItem(item: Any){
        items.add(item)
        notifyItemInserted(items.size - 1)
    }

    class ViewHolder(itemView: View, private val callbacks: SimpleCallbacks): RecyclerView.ViewHolder(itemView){
        fun bind(item: Any){
            callbacks.bindView(itemView, item, adapterPosition)
            itemView.setOnClickListener { callbacks.onViewClicked(it, item, adapterPosition) }
            itemView.setOnLongClickListener { callbacks.onViewLongClicked(it, item, adapterPosition)
                return@setOnLongClickListener true
            }
        }
    }
}