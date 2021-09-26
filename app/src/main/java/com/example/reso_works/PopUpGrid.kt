package com.example.reso_works

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.grid_item.view.*

class GridAdapter (private  val grid_list : List<GridItem>): RecyclerView.Adapter<GridAdapter.GridViewHolder>(){

    class GridViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.title
        val desc : TextView = itemView.desc
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popup_grid,parent,false)
        return GridViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        var currentItem = grid_list[position]

        holder.title.setText(currentItem.title)
        holder.desc.setText(currentItem.desc)
    }

    override fun getItemCount(): Int {
        return grid_list.size
    }
}