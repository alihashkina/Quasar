package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.PhotoItemBinding
import com.bumptech.glide.Glide

class PhotoAdapter(var photoList: MutableList<String>) :
    RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoList[position])
    }

    override fun getItemCount(): Int = photoList.size

    inner class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgPhoto = PhotoItemBinding.bind(view).imgPhoto
        var delete = PhotoItemBinding.bind(view).deletePhotoImageView

        fun bind(item: String) {
            Glide.with(itemView).load(item).into(imgPhoto)
            delete.setOnClickListener {
                photoList.remove(item)
                notifyDataSetChanged()
            }
        }
    }

}