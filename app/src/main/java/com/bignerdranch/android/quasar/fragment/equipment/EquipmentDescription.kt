package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.EquipmentDescriptionFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.EquipmentDescriptionViewModel

class EquipmentDescription : Fragment() {

    companion object {
        fun newInstance() = EquipmentDescription()
    }

    private lateinit var viewModel: EquipmentDescriptionViewModel
lateinit var bindingEquipmentDescription: EquipmentDescriptionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingEquipmentDescription= DataBindingUtil.inflate(inflater, R.layout.equipment_description_fragment,container,false)
        return bindingEquipmentDescription.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipmentDescriptionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}