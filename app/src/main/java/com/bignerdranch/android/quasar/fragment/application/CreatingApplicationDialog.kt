package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
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
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, QRScan.newInstance()).addToBackStack(null).commit()
            dismiss()
        }

        bindingCreatingApplicationDialog.txtCreatingApplicationDialogComm.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnCreatingApplicationDialog(bindingCreatingApplicationDialog.txtCreatingApplicationDialogComm, bindingCreatingApplicationDialog.btnCreatingApplicationDialogCreateApplication)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        bindingCreatingApplicationDialog.btnCreatingApplicationDialogCreateApplication.setOnClickListener{
            if(CreatingApplicationDialogViewModel.trueFalseClickCreatingApplicationDialog.contains("true"))
            {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsAll.newInstance()).addToBackStack(null).commit()
                dismiss()
            }
        }

    }


    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}