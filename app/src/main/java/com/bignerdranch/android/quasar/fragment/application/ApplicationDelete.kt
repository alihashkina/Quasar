package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationDeleteViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ApplicationDelete : DialogFragment() {

    companion object {
        fun newInstance() = ApplicationDelete()
    }

    private lateinit var viewModel: ApplicationDeleteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.application_delete_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationDeleteViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun getTheme() = R.style.DeleteAppBottomSheetDialogTheme
}