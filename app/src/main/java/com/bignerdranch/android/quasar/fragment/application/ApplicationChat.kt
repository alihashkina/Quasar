package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationChatFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationChatViewModel

class ApplicationChat : Fragment() {

    companion object {
        fun newInstance() = ApplicationChat()
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
        bindingApplicationChat.txtApplicationChatBack.setOnClickListener{
            findNavController().navigate(R.id.application)
        }
    }

}