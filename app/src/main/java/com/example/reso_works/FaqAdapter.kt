package com.example.reso_works

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.faq_list_item.view.*

class FaqAdapter(private val faq_list : List<FaqItem>) : RecyclerView.Adapter<FaqAdapter.FaqViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.faq_list_item,parent,false)
        return FaqViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        var currentItem = faq_list[position]
        holder.question.setText(currentItem.quesition)
        holder.answer.setText(currentItem.answer)

        val isVisible : Boolean = currentItem.isVisible

        holder.linearLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
        holder.imageView.rotation = if(isVisible) 90.0F else 360.0F
        holder.question.setOnClickListener{

            currentItem.isVisible = !currentItem.isVisible
            notifyItemChanged(position)
        }

    }

    override fun getItemCount() = faq_list.size

    class FaqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val question : TextView = itemView.question
        val answer : TextView = itemView.answer
        val linearLayout : LinearLayout = itemView.hide
        val imageView : ImageView = itemView.arrow_img
    }
}