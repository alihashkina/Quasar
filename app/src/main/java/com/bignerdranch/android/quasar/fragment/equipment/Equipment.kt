package com.bignerdranch.android.quasar.fragment.equipment

import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.EquipmentFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.CreatingApplicationDialog
import com.bignerdranch.android.quasar.fragment.application.ListOfApplicationsEmpty
import com.bignerdranch.android.quasar.fragment.settingprofile.GeneralPage
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bignerdranch.android.quasar.MainActivity.Companion.fragmentMenu
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
        MainActivity.menu.visibility = VISIBLE
    bindingEquipment.txtEquipmentBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Табы
        bindingEquipment.cardViewDescription.setOnClickListener {
            bindingEquipment.cardViewDescription.cardElevation = 30f
            bindingEquipment.cardViewFeatures.cardElevation = 0f
            bindingEquipment.cardViewCertifications.cardElevation = 0f

            bindingEquipment.cardViewDescription.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            bindingEquipment.cardViewFeatures.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
            bindingEquipment.cardViewCertifications.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
        }
        bindingEquipment.cardViewFeatures.setOnClickListener {
            bindingEquipment.cardViewDescription.cardElevation = 0f
            bindingEquipment.cardViewFeatures.cardElevation = 30f
            bindingEquipment.cardViewCertifications.cardElevation = 0f

            bindingEquipment.cardViewDescription.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
            bindingEquipment.cardViewFeatures.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            bindingEquipment.cardViewCertifications.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
        }
        bindingEquipment.cardViewCertifications.setOnClickListener {
            bindingEquipment.cardViewDescription.cardElevation = 0f
            bindingEquipment.cardViewFeatures.cardElevation = 0f
            bindingEquipment.cardViewCertifications.cardElevation = 30f

            bindingEquipment.cardViewDescription.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
            bindingEquipment.cardViewFeatures.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.tab_back))
            bindingEquipment.cardViewCertifications.setCardBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        }

    }

}