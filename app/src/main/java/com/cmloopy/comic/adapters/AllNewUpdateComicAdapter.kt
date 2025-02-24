package com.cmloopy.comic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.models.Comic
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView

class AllNewUpdateComicAdapter(private val itemList: ArrayList<Comic>): RecyclerView.Adapter<AllNewUpdateComicAdapter.ItemViewHolder>(){

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img_bia = itemView.findViewById<ShapeableImageView>(R.id.img_bia)
        val name_cm = itemView.findViewById<MaterialTextView>(R.id.txt_namecm)
        val name_author = itemView.findViewById<MaterialTextView>(R.id.txt_authorcm)
        val new = itemView.findViewById<MaterialTextView>(R.id.txt_newest_chapter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_comic,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //Picasso?
        holder.img_bia.setImageResource(itemList[position].img)
        holder.name_cm.setText(itemList[position].nameComic)
        holder.name_author.setText(itemList[position].nameAuthor)
        holder.new.setText(itemList[position].newChapter)
    }
}