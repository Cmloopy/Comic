package com.cmloopy.comic.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.view.ReadActivity
import com.cmloopy.comic.models.Chapter
import com.google.android.material.textview.MaterialTextView

class ListChapAdapter(val itemList: ArrayList<Chapter>): RecyclerView.Adapter<ListChapAdapter.ChapterViewHolder>() {

    class ChapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nameChapter = itemView.findViewById<MaterialTextView>(R.id.name_chap)
        val timeStamp = itemView.findViewById<MaterialTextView>(R.id.time_stamp)
        val like = itemView.findViewById<MaterialTextView>(R.id.txt_sllike)
        val cmt = itemView.findViewById<MaterialTextView>(R.id.txt_slcm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chap,parent,false)
        return ChapterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        holder.nameChapter.text = itemList[position].nameChapter
        holder.timeStamp.text = itemList[position].updatedAt.toString().substring(0,10)
        holder.like.text = itemList[position].likeChapter.toString()
        holder.cmt.text = itemList[position].viewChapter.toString()

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ReadActivity::class.java)
            context.startActivity(intent)
        }
    }
}