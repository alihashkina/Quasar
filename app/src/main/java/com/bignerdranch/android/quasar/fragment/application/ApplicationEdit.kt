package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationEditFragmentBinding
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationEditViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.application.CreatingApplicationDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ApplicationEdit : BottomSheetDialogFragment() {

    companion object {
        fun newInstance() = ApplicationEdit()
    }

    private lateinit var viewModel: ApplicationEditViewModel
lateinit var bindingApplicationEdit: ApplicationEditFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingApplicationEdit= DataBindingUtil.inflate(inflater, R.layout.application_edit_fragment,container,false)
        return bindingApplicationEdit.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationEditViewModel::class.java)
        bindingApplicationEdit.txtApplicationEditBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Application.newInstance()).addToBackStack(null).commit()
            dismiss()
        }

        bindingApplicationEdit.imgApplicationEditQR.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, QRScan.newInstance()).addToBackStack(null).commit()
            dismiss()
        }

        bindingApplicationEdit.txtApplicationEditComm.addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnApplicationEdit(bindingApplicationEdit.txtApplicationEditComm, bindingApplicationEdit.btnApplicationEditSave)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        bindingApplicationEdit.btnApplicationEditSave.setOnClickListener{
            dismiss()
        }

    }

    override fun getTheme() = R.style.AppBottomSheetDialogTheme

}