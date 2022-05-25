package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.EquipmentViewModel

class Equipment : Fragment() {

    companion object {
        fun newInstance() = Equipment()
    }

    private lateinit var viewModel: EquipmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.equipment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipmentViewModel::class.java)
        // TODO: Use the ViewModel

    }

}