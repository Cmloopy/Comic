package com.cmloopy.comic.adapters

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.models.Chapter
import com.cmloopy.comic.view.ReadActivity
import com.google.android.material.button.MaterialButton

class DialogAllChapAdapter(private val itemList: ArrayList<Chapter>,
                           private val posit: Int,
                           private val onItemClick: (Chapter) -> Unit): RecyclerView.Adapter<DialogAllChapAdapter.DialogAllChapterViewHolder>() {
    class DialogAllChapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val nameChapp = itemView.findViewById<MaterialButton>(R.id.txt_name_chapters)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogAllChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_custom_dialog,parent,false)
        return DialogAllChapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DialogAllChapterViewHolder, position: Int) {
        holder.nameChapp.text = itemList[position].nameChapter
        if (position == posit){
            holder.nameChapp.setTextColor(Color.parseColor("#FF526E"))
            val colorStateList = ColorStateList.valueOf(Color.parseColor("#ff526e"))
            holder.nameChapp.strokeColor = colorStateList
        }
        else{
            holder.nameChapp.setTextColor(Color.parseColor("#FF333333"))
            val colorStateList = ColorStateList.valueOf(Color.parseColor("#FF333333"))
            holder.nameChapp.strokeColor = colorStateList
        }
        holder.nameChapp.setOnClickListener {
            onItemClick(itemList[position])
        }
    }

}