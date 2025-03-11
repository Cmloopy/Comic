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

class TopAdapter(private val itemList: ArrayList<Comic>,private val idUser:Int, private val choose: Int): RecyclerView.Adapter<TopAdapter.ItemViewHolder>() {
    private val storageReference = FirebaseStorage.getInstance().reference
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val topbxh = itemView.findViewById<ShapeableImageView>(R.id.img_top)
        val bia = itemView.findViewById<ShapeableImageView>(R.id.img_bia_top)
        val namecm = itemView.findViewById<MaterialTextView>(R.id.txt_namecm_top)
        val sl = itemView.findViewById<MaterialTextView>(R.id.txt_sl_top)
        val auth = itemView.findViewById<MaterialTextView>(R.id.txt_authorcm_top)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.topbxh.setImageResource(
            when(position) {
                0 -> R.drawable.t1
                1 -> R.drawable.t2
                2 -> R.drawable.t3
                3 -> R.drawable.t4
                4 -> R.drawable.t5
                5 -> R.drawable.t6
                else -> R.drawable.t7
            }
        )
        val imageRef = storageReference.child(itemList[position].imageUrl)
        imageRef.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get()
                .load(uri)
                .placeholder(R.drawable.loading)
                .error(R.drawable.warning)
                .into(holder.bia)
        }.addOnFailureListener { exception ->
            // Xử lý khi có lỗi xảy ra trong quá trình tải ảnh
        }
        holder.namecm.text = itemList[position].nameComic
        when(choose){
            0 -> holder.sl.text = itemList[position].view.toString()
            1 -> holder.sl.text = itemList[position].likes.toString()
            else -> holder.sl.text = "8000"
        }
        holder.auth.text = itemList[position].nameAuthor
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ComicDetailActivity::class.java)
            intent.putExtra("idComic", itemList[position].idComic)
            intent.putExtra("idUser", idUser)
            holder.itemView.context.startActivity(intent)
        }
    }
}