package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationViewModel

class Application : Fragment() {

    companion object {
        fun newInstance() = Application()
    }

    private lateinit var viewModel: ApplicationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.application_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationViewModel::class.java)
        // TODO: Use the ViewModel
    }

}