package com.bignerdranch.android.quasar.fragment.equipment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.equipment.EquipmentCertificatesViewModel

class EquipmentCertificates : Fragment() {

    companion object {
        fun newInstance() = EquipmentCertificates()
    }

    private lateinit var viewModel: EquipmentCertificatesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.equipment_certificates_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EquipmentCertificatesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}