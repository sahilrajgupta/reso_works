package com.example.reso_works

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_item.view.*
import kotlinx.android.synthetic.main.popup_window.view.*

class PopUpGrid(private val faq_list : List<GridItem>, private val onItemClickListener : OnItemClickListener) : RecyclerView.Adapter<PopUpGrid.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.grid_item,parent,false)
        val itemView1 = LayoutInflater.from(parent.context).inflate(R.layout.popup_window,parent,false)
        return ViewHolder(itemView,itemView1,onItemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var currentItem = faq_list[position]
        holder.title.setText(currentItem.title)
        //holder.desc.setText(currentItem.desc)
    }

    override fun getItemCount() = faq_list.size

    class ViewHolder(itemView: View, itemView1: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener{
                onItemClickListener.onClick(adapterPosition)
            }
        }

        val title : TextView = itemView.title
        //val desc : TextView = itemView1.description

    }
    interface OnItemClickListener{
        fun onClick(position: Int)
    }
}