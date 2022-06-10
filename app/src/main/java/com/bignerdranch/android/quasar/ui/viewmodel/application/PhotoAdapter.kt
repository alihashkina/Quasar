package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.PhotoItemBinding

class PhotoAdapter(var photo: ArrayList<ImageView>): RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.photo_item,parent,false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photo[position])
    }

    override fun getItemCount(): Int = photo.size

    inner class PhotoViewHolder(view: View): RecyclerView.ViewHolder(view){
        var imgPhoto =  PhotoItemBinding.bind(view).imgPhoto

        fun bind(item: ImageView){
            imgPhoto = item
        }
    }

}