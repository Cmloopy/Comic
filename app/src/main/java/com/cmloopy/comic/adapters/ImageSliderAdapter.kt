package com.cmloopy.comic.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.cmloopy.comic.R
import Comic
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class ImageSliderAdapter(private var hotComic: ArrayList<Comic>, private var viewpager2: ViewPager2)
    : RecyclerView.Adapter<ImageSliderAdapter.ImageViewHolder>() {
    private val storageReference = FirebaseStorage.getInstance().reference

    class ImageViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val bia = itemView.findViewById<ShapeableImageView>(R.id.imgBia)!!
        val tt = itemView.findViewById<MaterialTextView>(R.id.txtNameComic)!!
        val aut = itemView.findViewById<MaterialTextView>(R.id.txtAuthor)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hotComic.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.tt.text = hotComic[position].nameComic
        holder.aut.text = hotComic[position].nameAuthor
        val imageRef = storageReference.child(hotComic[position].imageUrl)
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get()
                .load(uri)
                .placeholder(R.drawable.loading)
                .error(R.drawable.warning)
                .into(holder.bia)
        }.addOnFailureListener { exception ->
            println(exception)
        }
        if (position == hotComic.size-1){
            viewpager2.post(runnable)
        }

    }

    //Add lại list để tạo hiệu ứng cuộn vô hạn
    private val runnable = Runnable {
        hotComic.addAll(hotComic)
        notifyDataSetChanged()
    }
}