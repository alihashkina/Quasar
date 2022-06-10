package com.bignerdranch.android.quasar.fragment.application

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationChatFragmentBinding
import com.bignerdranch.android.quasar.databinding.PhotoItemBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationChatViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationChatViewModel.Companion.msgTrueFale
import com.bignerdranch.android.quasar.ui.viewmodel.application.PhotoAdapter
import android.R.attr.data




class ApplicationChat : Fragment() {

    companion object {
        fun newInstance() = ApplicationChat()
        val REQUEST_CODE = 100
        var photoImg: ArrayList<ImageView> = ArrayList()
    }


    private lateinit var viewModel: ApplicationChatViewModel
    lateinit var bindingApplicationChat: ApplicationChatFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingApplicationChat= DataBindingUtil.inflate(inflater, R.layout.application_chat_fragment,container,false)
        return bindingApplicationChat.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationChatViewModel::class.java)
        MainActivity.menu.visibility = GONE

        bindingApplicationChat.txtApplicationChatBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Application.newInstance()).addToBackStack(null).commit()
        }
        viewModel.clickMsg(bindingApplicationChat.txtApplicationChatMsg)
        bindingApplicationChat.imgApplicationChatMagPost.isClickable = msgTrueFale


bindingApplicationChat.imgApplicationChatMsgPhoto.setOnClickListener{
    getPhoto()
}

    }
    fun getPhoto() {
    val intent = Intent(Intent.ACTION_PICK)
    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
    intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
     data?.extras
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            bindingApplicationChat.linearPhoto.visibility = VISIBLE
           // bindingApplicationChat.imageView2.setImageURI(data?.data)
            //не работает
            photoImg = arrayListOf(PhotoItemBinding.bind(view!!).imgPhoto)
          photoImg[0].setImageURI(data?.data)
            photoImg[1].setImageURI(data?.data)
            photoImg[2].setImageURI(data?.data)
            bindingApplicationChat.recyclerPhoto.layoutManager = GridLayoutManager(requireContext(), 3)
            bindingApplicationChat.recyclerPhoto.adapter = PhotoAdapter(photoImg)
        }
    }

}