package com.revosleap.simpleadapter

import android.view.View

class SimpleAdapter(val layout: Int, private val callbacks: SimpleCallbacks): RecyclerView.Adapter<SimpleAdapter.ViewHolder>(){
    inner class ViewHolder(private val itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Any){

        }
    }
}