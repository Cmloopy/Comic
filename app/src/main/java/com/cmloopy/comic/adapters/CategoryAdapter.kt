package com.cmloopy.comic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.models.Category
import com.google.android.material.textview.MaterialTextView

class CategoryAdapter(private val itemList: ArrayList<Category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameCate = itemView.findViewById<MaterialTextView>(R.id.txt_cate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.nameCate.text = itemList[position].nameCategory
    }
}