package com.bignerdranch.android.quasar.fragment.application

import android.content.ContentResolver
import android.content.res.ColorStateList
import android.database.Cursor
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract.EventDays.query
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media.query
import android.provider.MediaStore.Images.Thumbnails.query
import android.provider.MediaStore.Video.query
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.PickPhotoBottomSheetBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.PickImageAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PickImageDialog : BottomSheetDialogFragment() {

    companion object{
        fun newInstance() = PickImageDialog()
    }

    private var _binding: PickPhotoBottomSheetBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageList: List<String>
    val imageMap = mutableMapOf<Int, String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= PickPhotoBottomSheetBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Чтобы окно можно было сделать с круглыми краями
        val bottomSheet = view.parent as View
        bottomSheet.backgroundTintList = ColorStateList.valueOf(Color.TRANSPARENT)
        //

        binding.done.setOnClickListener {
            // Передадим массив с фото в предыдуший фрагмент
            Log.i("My", "Done List: $imageMap")
            setFragmentResult("requestKeyImages", bundleOf("bundleKeyImages" to imageMap))
            dismiss()
        }

        imageList = getCameraImages().reversed()// получим список ссылок на фото
        binding.recyclerPickImages.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL)
        binding.recyclerPickImages.adapter = PickImageAdapter(imageList){ position, pathImage, check ->
            if(check){
                imageMap.put(position, pathImage)
            }else{
                imageMap.remove(position)
            }
        }
    }

    // Мы получим список с сылками на каждую фотографию из вашей галереи и дальше можно загружать через Glide
    fun getCameraImages(): List<String> {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI// ссылка на медиафайлы
        val cursor: Cursor?// работа с курсором интерфейса
        val listOfAllImages = ArrayList<String>()// список изображений
        var absolutePathOfImage: String?// путь изображения

        val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.DISPLAY_NAME)

        cursor = context!!.applicationContext.contentResolver.query(uri, projection, null, null, null);

        var columnIndexData: Int = cursor!!.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        var columnIndexFolderName: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(columnIndexData)
            listOfAllImages.add(absolutePathOfImage)
        }
        return listOfAllImages
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}