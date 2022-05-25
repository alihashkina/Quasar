package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.databinding.UserAgreementFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.login.UserAgreementViewModel

class UserAgreement : Fragment() {

    companion object {
        fun newInstance() = UserAgreement()
    }

    private lateinit var viewModel: UserAgreementViewModel
    lateinit var bindingUserAgreement: UserAgreementFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        bindingUserAgreement= DataBindingUtil.inflate(inflater, R.layout.user_agreement_fragment,container,false)
//        val view: View = bindingUserAgreement.getRoot()
//        return view
        bindingUserAgreement= DataBindingUtil.inflate(inflater, R.layout.user_agreement_fragment,container,false)
        return bindingUserAgreement.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserAgreementViewModel::class.java)
       // viewModel.loadUserAgreement(bindingUserAgreement.webUserAgreement)
        // TODO: Use the ViewModel

    }

}