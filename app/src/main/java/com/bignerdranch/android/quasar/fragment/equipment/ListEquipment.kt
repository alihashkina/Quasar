package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ListEquipmentFragmentBinding
import com.bignerdranch.android.quasar.databinding.ListEquipmentFragmentBindingImpl
import com.bignerdranch.android.quasar.fragment.settingprofile.GeneralPage
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.ListEquipmentViewModel

class ListEquipment : Fragment() {

    companion object {
        fun newInstance() = ListEquipment()
    }

    private lateinit var viewModel: ListEquipmentViewModel
    lateinit var bindingListEquipment: ListEquipmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingListEquipment= DataBindingUtil.inflate(inflater, R.layout.list_equipment_fragment,container,false)
        return bindingListEquipment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListEquipmentViewModel::class.java)
        MainActivity.menu.visibility = VISIBLE

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}