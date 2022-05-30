package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.databinding.RecoveryCodeFragmentBinding
import com.bignerdranch.android.quasar.databinding.RecoveryFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.login.RecoveryCodeViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.login.RecoveryViewModel

class RecoveryCode : Fragment() {

    companion object {
        fun newInstance() = RecoveryCode()
    }

    private lateinit var viewModel: RecoveryCodeViewModel
    lateinit var bindingRecoveryCode: RecoveryCodeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingRecoveryCode= DataBindingUtil.inflate(inflater, R.layout.recovery_code_fragment,container,false)
        return bindingRecoveryCode.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecoveryCodeViewModel::class.java)

        bindingRecoveryCode.txtRecoveryCodeTermsOfUse.setOnClickListener{
            viewModel.openNewTabWindowCode("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingRecoveryCode.txtRecoveryCodeBack.setOnClickListener{
            findNavController().navigate(R.id.recovery)
        }

        bindingRecoveryCode.txtRecoveryCodeEnterTheCode.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnCode(bindingRecoveryCode.txtRecoveryCodeEnterTheCode, bindingRecoveryCode.btnRecoveryCodeLogInToTheSystem)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        bindingRecoveryCode.btnRecoveryCodeLogInToTheSystem.setOnClickListener{
            viewModel.errorClickCode(bindingRecoveryCode.txtRecoveryCodeEnterTheCode, bindingRecoveryCode.txtRecoveryCodeError)
            if(RecoveryCodeViewModel.trueFalseErrorCode.contains("false")){
                findNavController().navigate(R.id.mainFragment)
            }
        }
    }

}