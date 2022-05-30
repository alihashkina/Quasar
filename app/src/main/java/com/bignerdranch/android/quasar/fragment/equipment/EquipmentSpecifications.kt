package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.EquipmentSpecificationsFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.EquipmentSpecificationsViewModel

class EquipmentSpecifications : Fragment() {

    companion object {
        fun newInstance() = EquipmentSpecifications()
    }

    private lateinit var viewModel: EquipmentSpecificationsViewModel
lateinit var bindingEquipmentSpecifications: EquipmentSpecificationsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingEquipmentSpecifications= DataBindingUtil.inflate(inflater, R.layout.equipment_specifications_fragment,container,false)
        return bindingEquipmentSpecifications.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipmentSpecificationsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}