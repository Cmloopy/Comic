package com.cmloopy.comic.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import Comic
import com.cmloopy.comic.view.ComicDetailActivity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso

class HomeListComicAdapter(private val itemList: ArrayList<Comic>): RecyclerView.Adapter<HomeListComicAdapter.ItemViewHolder>() {
    private val storageReference = FirebaseStorage.getInstance().reference
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgBia = itemView.findViewById<ShapeableImageView>(R.id.img_bia)!!
        val nameCm = itemView.findViewById<MaterialTextView>(R.id.txt_namecm)!!
        val nameAuthor = itemView.findViewById<MaterialTextView>(R.id.txt_authorcm)!!
        val new = itemView.findViewById<MaterialTextView>(R.id.txt_newest_chapter)!!
        val status = itemView.findViewById<MaterialTextView>(R.id.txt_status)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_comic,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val imageRef = storageReference.child(itemList[position].imageUrl)
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get()
                .load(uri)
                .placeholder(R.drawable.loading)
                .error(R.drawable.warning)
                .into(holder.imgBia)
        }.addOnFailureListener { exception ->
            // Xử lý khi có lỗi xảy ra trong quá trình tải ảnh
        }
        holder.nameCm.text = (itemList[position].nameComic)
        holder.nameAuthor.text = (itemList[position].nameAuthor)
        holder.new.text = (itemList[position].nameChapter)
        if(itemList[position].status == 1){
            holder.status.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context,ComicDetailActivity::class.java)
            intent.putExtra("comic", itemList[position].idComic)
            context.startActivity(intent)
        }
    }
}