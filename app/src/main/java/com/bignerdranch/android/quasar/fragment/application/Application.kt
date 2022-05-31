package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationFragmentBinding
import com.bignerdranch.android.quasar.databinding.MainFragmentBinding
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.fragment.login.Recovery
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationViewModel

class Application : Fragment() {

    companion object {
        fun newInstance() = Application()
    }

    private lateinit var viewModel: ApplicationViewModel
lateinit var bindingApplication: ApplicationFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingApplication= DataBindingUtil.inflate(inflater, R.layout.application_fragment,container,false)
        return bindingApplication.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ApplicationViewModel::class.java)
        MainActivity.menu.visibility = GONE
        bindingApplication.txtApplicationBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsAll.newInstance()).addToBackStack(null).commit()
              }

        bindingApplication.constrApplicationChat.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ApplicationChat.newInstance()).addToBackStack(null).commit()
        }

        bindingApplication.constrArchiveApplication.setOnClickListener{
            ApplicationDelete().show(fragmentManager!!, "d")
        }

        bindingApplication.constrApplicationEditApplication.setOnClickListener{
            ApplicationEdit().show(fragmentManager!!, "d")
        }

        bindingApplication.constrApplication.setOnClickListener{
//            findNavController().navigate(R.id.equipment)
//            childFragmentManager.beginTransaction()
//                .replace(R.id.containerViewMain, Equipment.newInstance())
//                .addToBackStack(null)
//                .commit()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Equipment.newInstance()).addToBackStack(null).commit()
        }
    }

}