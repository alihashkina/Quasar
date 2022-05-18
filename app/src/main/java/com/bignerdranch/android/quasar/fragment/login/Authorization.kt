package com.bignerdranch.android.quasar.fragment.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel

class Authorization : Fragment() {

    companion object {
        fun newInstance() = Authorization()
    }

    private lateinit var viewModel: AuthorizationViewModel
    lateinit var bindingAuthorization: AuthorizationFragmentBinding
  //  var txtAuthorizationLogin = bindingAuthorization.txtAuthorizationLogin
   var btnAuthorizationLogin = bindingAuthorization.btnAuthorizationLogin

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingAuthorization = DataBindingUtil.inflate(inflater,R.layout.authorization_fragment,container,false)
        return bindingAuthorization.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthorizationViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnAuthorizationLogin.setOnClickListener{
            findNavController().navigate(R.id.menu)
        }

    }
}