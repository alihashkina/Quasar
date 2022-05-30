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
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ApplicationFragmentBinding
import com.bignerdranch.android.quasar.databinding.MainFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ApplicationViewModel

class Application : Fragment() {

    companion object {
        fun newInstance() = Application()
    }

    private lateinit var viewModel: ApplicationViewModel
lateinit var bindingApplication: ApplicationFragmentBinding
lateinit var bindingMainFragment: MainFragmentBinding

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

        bindingApplication.txtApplicationBack.setOnClickListener{
            findNavController().navigate(R.id.listOfApplicationsAll)
        }

        bindingApplication.constrApplicationChat.setOnClickListener{
            findNavController().navigate(R.id.applicationChat)
        }

    }

}