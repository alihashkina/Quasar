package com.bignerdranch.android.quasar.fragment.application

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.graphics.component1
import androidx.core.view.size
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.CreatingApplicationDialogFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.QRScan.Companion.key
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.ui.viewmodel.application.CreatingApplicationDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.json.JSONObject

class CreatingApplicationDialog : BottomSheetDialogFragment() {

    companion object {
        const val RESULTCreate= "RESULT"
                fun newInstance(result:String) = CreatingApplicationDialog().apply {
            arguments = Bundle().apply {
                putString(RESULTCreate, result)
            }
        }
        var spinnerArray = arrayOf<String>("", "", "")
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreatingApplicationDialogViewModel::class.java)


        var qrResult = arguments?.getString(RESULTCreate)
        if(qrResult!=null) {
            var js = JSONObject(qrResult)
         spinnerArray[0] += js.getString("equipment")
        }


        if (bindingCreatingApplicationDialog.spinnerCreatingApplicationDialogApplication != null) {
            val adapter = ArrayAdapter(context!!.applicationContext,
                R.layout.spinner_item, spinnerArray)
            bindingCreatingApplicationDialog.spinnerCreatingApplicationDialogApplication.adapter = adapter
            adapter.setDropDownViewResource(R.layout.spinner_item)
            bindingCreatingApplicationDialog.spinnerCreatingApplicationDialogApplication.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        bindingCreatingApplicationDialog.txtCreatingApplicationDialogBack.setOnClickListener{
            dismiss()
            ApplicationEdit().show(fragmentManager!!, "d")
        }

        bindingCreatingApplicationDialog.imgCreatingApplicationDialogQR.setOnClickListener{
            ApplicationEdit.qrFragmentBack = "CreatingApplicationDialog"
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