package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.CreatingApplicationDialogFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.CreatingApplicationDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreatingApplicationDialog : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = CreatingApplicationDialog()
    }

    private lateinit var viewModel: CreatingApplicationDialogViewModel
lateinit var bindingCreatingApplicationDialog: CreatingApplicationDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingCreatingApplicationDialog= DataBindingUtil.inflate(inflater, R.layout.creating_application_dialog_fragment,container,false)
        return bindingCreatingApplicationDialog.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreatingApplicationDialogViewModel::class.java)

        bindingCreatingApplicationDialog.txtCreatingApplicationDialogBack.setOnClickListener{
            dismiss()
        }

        bindingCreatingApplicationDialog.imgCreatingApplicationDialogQR.setOnClickListener{
            findNavController().navigate(R.id.QRScan2)
        }

        bindingCreatingApplicationDialog.btnCreatingApplicationDialogCreateApplication.setOnClickListener{
            findNavController().navigate(R.id.listOfApplicationsAll2)
        }

    }


    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}