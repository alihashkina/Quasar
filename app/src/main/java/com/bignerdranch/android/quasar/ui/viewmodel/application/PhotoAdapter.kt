package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.PhotoItemBinding
import com.bumptech.glide.Glide
import java.io.File

class PhotoAdapter(var photo: ArrayList<File>) :
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
        holder.bind(photo[position])
    }

    override fun getItemCount(): Int = photo.size

    inner class PhotoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgPhoto = PhotoItemBinding.bind(view).imgPhoto
        var delete = PhotoItemBinding.bind(view).deletePhotoImageView

        fun bind(item: File) {
            Glide.with(itemView).load(item).into(imgPhoto)
            delete.setOnClickListener {
                photo.remove(item)
                notifyDataSetChanged()
            }
        }
    }

}