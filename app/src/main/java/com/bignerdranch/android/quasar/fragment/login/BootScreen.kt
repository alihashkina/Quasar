package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.login.BootScreenViewModel

class BootScreen : Fragment() {

    companion object {
        fun newInstance() = BootScreen()
    }

    private lateinit var viewModel: BootScreenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.boot_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BootScreenViewModel::class.java)
        // TODO: Use the ViewModel
           }

}