package com.bignerdranch.android.quasar.fragment.application

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationChatFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationChatViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationChatViewModel.Companion.msgTrueFale
import com.bignerdranch.android.quasar.ui.viewmodel.application.PhotoAdapter

class ApplicationChat : Fragment() {

    companion object {
        fun newInstance() = ApplicationChat()
        // Переменные для доступа к галерее
        const val WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
        const val READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    }

    private lateinit var viewModel: ApplicationChatViewModel
    private lateinit var bindingApplicationChat: ApplicationChatFragmentBinding
    private lateinit var requestPermissionLauncher: ActivityResultLauncher<String>
    private var currentPermission = READ_EXTERNAL_STORAGE
    private var resultImages:  MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Получим от нижнего фрагмента выбранные изображения
        setFragmentResultListener("requestKeyImages") { key, bundle ->
            val result = bundle.get("bundleKeyImages") as MutableMap<Int, String>
            resultImages = result.values.toMutableList()
            Log.i("My", "Result: $result")

            if(resultImages != null){
                bindingApplicationChat.linearPhoto.visibility = VISIBLE

                bindingApplicationChat.recyclerPhoto.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                bindingApplicationChat.recyclerPhoto.adapter = PhotoAdapter(resultImages!!)
            }
        }

        // Создадим переменную для получения разрешения, мы будем её использовать для запроса на разрешение
        requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                // Здесь выполняем код, когда разрешение предоставлено успешно
                if (currentPermission == READ_EXTERNAL_STORAGE){
                    Log.i("My", "Read first")
                    currentPermission = WRITE_EXTERNAL_STORAGE
                    checkPermission(WRITE_EXTERNAL_STORAGE)
                }else if(currentPermission == WRITE_EXTERNAL_STORAGE){
                    Log.i("My", "Write first")
                    getPhoto()
                }

            } else {
                // Если разрешение не предоставлено
                Toast.makeText(requireContext(), "Предоставьте разрешение на чтение файлов", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingApplicationChat =
            DataBindingUtil.inflate(inflater, R.layout.application_chat_fragment, container, false)
        return bindingApplicationChat.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationChatViewModel::class.java)
        MainActivity.menu.visibility = GONE

        bindingApplicationChat.txtApplicationChatBack.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.containerView, Application.newInstance()).addToBackStack(null)
                .commit()
        }
        viewModel.clickMsg(bindingApplicationChat.txtApplicationChatMsg)
        bindingApplicationChat.imgApplicationChatMagPost.isClickable = msgTrueFale


        bindingApplicationChat.imgApplicationChatMsgPhoto.setOnClickListener {
            checkPermission(READ_EXTERNAL_STORAGE)
        }
    }

    // Метод для проверки разрешения, сюда кладём нужное разрешение.
    private fun checkPermission(permission: String){

        // Проверим есть ли разрешение permission в PackageManager (если разрешение предоставлено, то PERMISSION_GRANTED)
        when {
            ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED -> {
                // Здесь выполняем код, если разрешение на чтение есть
                if (permission == READ_EXTERNAL_STORAGE){
                    Log.i("My", "Check Read")
                    currentPermission = WRITE_EXTERNAL_STORAGE
                    checkPermission(WRITE_EXTERNAL_STORAGE)
                }else if(permission == WRITE_EXTERNAL_STORAGE){
                    Log.i("My", "Check Write")
                    getPhoto()
                }
            }
            else -> {
                // Если разрешения нет, то получим его
                requestPermissionLauncher.launch(permission)
            }
        }
    }

    fun getPhoto() {
        PickImageDialog().show(requireActivity().supportFragmentManager,null)
    }


}