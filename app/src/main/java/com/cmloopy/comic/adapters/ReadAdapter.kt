package com.cmloopy.comic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class ReadAdapter(private val itemImageComic: List<String>): RecyclerView.Adapter<ReadAdapter.ReadViewHolder>() {
    private val storageReference = FirebaseStorage.getInstance().reference
    class ReadViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img_comic = itemView.findViewById<ShapeableImageView>(R.id.img_comic)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image_comic,parent,false)
        return ReadViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemImageComic.size
    }

    override fun onBindViewHolder(holder: ReadViewHolder, position: Int) {
        val imagePath = itemImageComic[position]
        val imageRef = storageReference.child(imagePath)
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get().load(uri).into(holder.img_comic)
        }.addOnFailureListener { exception ->
            println(exception)
        }
    }
}