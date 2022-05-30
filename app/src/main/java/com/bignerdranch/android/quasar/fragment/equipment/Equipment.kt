package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.EquipmentFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.EquipmentViewModel

class Equipment : Fragment() {

    companion object {
        fun newInstance() = Equipment()
    }

    private lateinit var viewModel: EquipmentViewModel
lateinit var bindingEquipment: EquipmentFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingEquipment= DataBindingUtil.inflate(inflater, R.layout.equipment_fragment,container,false)
        return bindingEquipment.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)
        bindingEquipment.txtEquipmentBack.setOnClickListener{
            findNavController().navigate(R.id.listEquipment2)
        }

    }

}