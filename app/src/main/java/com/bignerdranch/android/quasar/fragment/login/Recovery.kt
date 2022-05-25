package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.databinding.RecoveryFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.login.RecoveryViewModel

class Recovery : Fragment() {

    companion object {
        fun newInstance() = Recovery()
    }

    private lateinit var viewModel: RecoveryViewModel
    lateinit var bindingRecovery: RecoveryFragmentBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingRecovery = DataBindingUtil.inflate(inflater, R.layout.recovery_fragment,container,false)
        return bindingRecovery.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoveryViewModel::class.java)
        // TODO: Use the ViewModel
        bindingRecovery.btnRecoverySendTheCodeToTheMail.setOnClickListener{
findNavController().navigate(R.id.recoveryCode)
        }

        bindingRecovery.txtRecoveryTermsOfUse.setOnClickListener{
            viewModel.openNewTabWindow("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingRecovery.txtRecoveryBack.setOnClickListener{
            findNavController().navigate(R.id.authorization)
        }

    }




}