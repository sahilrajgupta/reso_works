package com.example.reso_works

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_item.view.*

class PopUpGrid(private val faq_list : List<GridItem>) : RecyclerView.Adapter<PopUpGrid.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = faq_list[position]
        holder.title.setText(currentItem.title)
        holder.desc.setText(currentItem.desc)
    }

    override fun getItemCount() = faq_list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.title
        val desc : TextView = itemView.desc

    }
}