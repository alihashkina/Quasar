package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.databinding.RecoveryFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.CreatingApplicationDialog
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
MainActivity.menu.visibility = GONE

        bindingRecovery.btnRecoverySendTheCodeToTheMail.setOnClickListener{
            viewModel.errorClickEmail(bindingRecovery.txtRecoveryEmail, bindingRecovery.txtRecoveryEmailError)
            if(RecoveryViewModel.trueFalseErrorEmail.contains("false")){
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, RecoveryCode.newInstance()).addToBackStack(null).commit()
            }
        }

        bindingRecovery.txtRecoveryTermsOfUse.setOnClickListener{
            viewModel.openNewTabWindowEmail("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingRecovery.txtRecoveryBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Authorization.newInstance()).addToBackStack(null).commit()
        }

        bindingRecovery.txtRecoveryEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnEmail(bindingRecovery.txtRecoveryEmail, bindingRecovery.btnRecoverySendTheCodeToTheMail)
                 }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


    }




}