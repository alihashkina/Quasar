package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ItemPickImageBinding
import com.bumptech.glide.Glide

class PickImageAdapter(private var imageList: List<String>,
                       private val clickListener: (position: Int, pathImage: String, check: Boolean) -> Unit):
    RecyclerView.Adapter<PickImageAdapter.PickImageViewHolder>() {

    // Ограничение - не больше 3-х элементов
    val limit = 3
    // Список для хранения отмеченных изображений
    var checked: BooleanArray = BooleanArray(imageList.size)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pick_image, parent, false)
        return PickImageViewHolder(view){ position ->
            clickListener(position, imageList[position], checked[position])
        }
    }

    override fun onBindViewHolder(holder: PickImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    inner class PickImageViewHolder(view: View, clickAtPosition: (Int) -> Unit) : RecyclerView.ViewHolder(view) {
        val binding = ItemPickImageBinding.bind(view)

        init {
            // Добавим при нажатии на фото в список checked значение true или false
            binding.selector.setOnClickListener {
                val trueImages = checked.filter {it == true}
                // Ограничим выбор количества фото
                if (!(trueImages.size > limit-1 && !checked[bindingAdapterPosition])){
                    checked[bindingAdapterPosition] = !checked[bindingAdapterPosition]
                    Log.i("My", "Checked")
                    clickAtPosition(bindingAdapterPosition)
                }else{
                    binding.selector.isChecked = false
                }

            }
        }

        fun bind(item: String) {
            // Загрузим изображение из пути item
            Glide.with(itemView).load(item).into(binding.image)
            // Отметим фото, если оно true в списке checked
            binding.selector.isChecked = checked[bindingAdapterPosition]
        }
    }
}