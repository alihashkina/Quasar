package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationEditViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ApplicationEdit : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = ApplicationEdit()
    }

    private lateinit var viewModel: ApplicationEditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.application_edit_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationEditViewModel::class.java)
        // TODO: Use the ViewModel

    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}