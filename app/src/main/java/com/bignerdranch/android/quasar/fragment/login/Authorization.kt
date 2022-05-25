package com.bignerdranch.android.quasar.fragment.login

import android.app.Activity
import android.app.ProgressDialog.show
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.fragment.MainFragment
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel
import org.w3c.dom.Text

class Authorization : Fragment() {

    companion object {
        fun newInstance() = Authorization()
        var checkbtnAuthorizationLogin = false
    }

    private lateinit var viewModel: AuthorizationViewModel
//    lateinit var bindingAuthorization: AuthorizationFragmentBinding
//    var txtAuthorizationLogin = bindingAuthorization.txtAuthorizationLogin
//   var btnAuthorizationLogin = bindingAuthorization.btnAuthorizationLogin
//    lateinit var bindingAuthorization: AuthorizationFragmentBinding
//    var txtAuthorizationYouDontHaveAccess = bindingAuthorization.txtAuthorizationYouDontHaveAccess
lateinit var bindingAuthorization: AuthorizationFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        bindingAuthorization = DataBindingUtil.setContentView(requireActivity(), R.layout.authorization_fragment)
       // bindingAuthorization.viewModelAuthorization = viewModel


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAuthorization= DataBindingUtil.inflate(inflater, R.layout.authorization_fragment,container,false)
        return bindingAuthorization.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthorizationViewModel::class.java)
        // TODO: Use the ViewModel
        bindingAuthorization.txtAuthorizationTermsOfUse.setOnClickListener {
            viewModel.openNewTabWindow("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingAuthorization.txtAuthorizationYouDontHaveAccess.setOnClickListener {
//            childFragmentManager.beginTransaction()
//                .replace(R.id.containerViewMain, Recovery.newInstance())
//                .addToBackStack(null)
//                .commit()
            findNavController().navigate(R.id.recovery)
        }

        bindingAuthorization.btnAuthorizationLogin.setOnClickListener {
            checkbtnAuthorizationLogin = true
            findNavController().navigate(R.id.mainFragment)
        }

//        if(Patterns.EMAIL_ADDRESS.matcher(bindingAuthorization.txtAuthorizationLogin.text).matches()){
//            bindingAuthorization.btnAuthorizationLogin.resources.getDrawable(R.color.blue)
//            Log.i("sdfsdf", "ssssssssss")
//        }

     bindingAuthorization.txtAuthorizationPassword.setOnClickListener{

       // while(bindingAuthorization.txtAuthorizationPassword.toString().isEmpty()){
            Log.i("txttt", "dddddddd")
            viewModel.backBtn(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword, bindingAuthorization.btnAuthorizationLogin)


//        }

      }

        bindingAuthorization.imgAuthorizationPassword.setOnClickListener{
           viewModel.drawablePassword(bindingAuthorization.imgAuthorizationPassword, bindingAuthorization.txtAuthorizationPassword)
        }
    }
}