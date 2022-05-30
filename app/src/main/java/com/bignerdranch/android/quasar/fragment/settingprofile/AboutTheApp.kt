package com.bignerdranch.android.quasar.fragment.settingprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AboutTheAppFragmentBinding
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.settingprofile.AboutTheAppViewModel

class AboutTheApp : Fragment() {

    companion object {
        fun newInstance() = AboutTheApp()
    }

    private lateinit var viewModel: AboutTheAppViewModel
    lateinit var bindingAboutTheApp: AboutTheAppFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAboutTheApp= DataBindingUtil.inflate(inflater, R.layout.about_the_app_fragment,container,false)
        return bindingAboutTheApp.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AboutTheAppViewModel::class.java)
        bindingAboutTheApp.txtAboutTheAppBack.setOnClickListener{
findNavController().navigate(R.id.generalPage)
        }
    }

}