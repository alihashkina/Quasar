package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationDeleteFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationDeleteViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ApplicationDelete : DialogFragment() {

    companion object {
        fun newInstance() = ApplicationDelete()
    }

    private lateinit var viewModel: ApplicationDeleteViewModel
lateinit var bindingApplicationDelete: ApplicationDeleteFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingApplicationDelete= DataBindingUtil.inflate(inflater, R.layout.application_delete_fragment,container,false)
        return bindingApplicationDelete.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationDeleteViewModel::class.java)

        bindingApplicationDelete.txtApplicationDeleteYes.setOnClickListener{
            dismiss()
        }

        bindingApplicationDelete.txtApplicationDeleteNo.setOnClickListener{
            dismiss()
        }
    }

    override fun getTheme() = R.style.DeleteAppBottomSheetDialogTheme
}