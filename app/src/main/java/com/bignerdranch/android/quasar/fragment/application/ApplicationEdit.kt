package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationEditFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.CreatingApplicationDialog.Companion.spinnerArray
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationEditViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.application.CreatingApplicationDialogViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.json.JSONObject

class ApplicationEdit : BottomSheetDialogFragment() {

    companion object {
        const val RESULTEdit= "RESULT"
        fun newInstance(result:String) = ApplicationEdit().apply {
            arguments = Bundle().apply {
                putString(RESULTEdit, result)
            }
        }
        var qrFragmentBack = ""
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

        var qrResult = arguments?.getString(RESULTEdit)
        if(qrResult!=null) {
            var js = JSONObject(qrResult)
            spinnerArray[1] += js.getString("equipment")
        }


        if (bindingApplicationEdit.spinnerApplicationEditApplication != null) {
            val adapter = ArrayAdapter(context!!.applicationContext,
                R.layout.spinner_item, spinnerArray)
            bindingApplicationEdit.spinnerApplicationEditApplication.adapter = adapter
            adapter.setDropDownViewResource(R.layout.spinner_item)
            bindingApplicationEdit.spinnerApplicationEditApplication.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                }

                override fun onNothingSelected(parent: AdapterView<*>) {

                }
            }
        }

        bindingApplicationEdit.txtApplicationEditBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Application.newInstance()).addToBackStack(null).commit()
            dismiss()
        }

        bindingApplicationEdit.imgApplicationEditQR.setOnClickListener{
            qrFragmentBack = "ApplicationEdit"
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