package com.bignerdranch.android.quasar.fragment.login

import android.app.Activity
import android.app.ProgressDialog.show
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
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
import com.bignerdranch.android.quasar.retrofit.common.Common
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel
import org.json.JSONObject
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            viewModel.openNewTabWindowAuth("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingAuthorization.txtAuthorizationYouDontHaveAccess.setOnClickListener {
//            childFragmentManager.beginTransaction()
//                .replace(R.id.containerViewMain, Recovery.newInstance())
//                .addToBackStack(null)
//                .commit()
            findNavController().navigate(R.id.recovery)
        }

        bindingAuthorization.btnAuthorizationLogin.setOnClickListener {
            viewModel.errorClickAuth(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword, bindingAuthorization.btnAuthorizationLogin, bindingAuthorization.txtAuthorizationLoginError, bindingAuthorization.txtAuthorizationPasswordError)
           if(AuthorizationViewModel.trueFalseErrorLogin.contains("false")) {
               findNavController().navigate(R.id.mainFragment)
           }
            }

        bindingAuthorization.txtAuthorizationLogin.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnAuth(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword, bindingAuthorization.btnAuthorizationLogin)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        bindingAuthorization.txtAuthorizationPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.backBtnAuth(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword, bindingAuthorization.btnAuthorizationLogin)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        fun authh(authorization: com.bignerdranch.android.quasar.retrofit.model.Authorization){
            Common.retrofitService.nn(authorization).enqueue(object: Callback<JSONObject> {

                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                    Log.d("MyLog", "callback AnonimToken" + response)
                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    Log.d("MyLog", "ERRRRRORRR TOKEN")
                }
            })
        }

        fun bb () {
            Common.retrofitService.bb("YWRtaW46MlprJV81TWpmUA==").enqueue(object: Callback<JSONObject>{
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                    // googleName()

                    Log.i("MyLog", "NOT ERROR AuthLogin" + response)
                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    Log.i("MyLog", "ERROR AuthLogin" + t)
                }
            })

        }

        bindingAuthorization.imgAuthorizationPassword.setOnClickListener{
           viewModel.drawablePassword(bindingAuthorization.imgAuthorizationPassword, bindingAuthorization.txtAuthorizationPassword)

            authh(com.bignerdranch.android.quasar.retrofit.model.Authorization("YWRtaW46MlprJV81TWpmUA==", "Android", "Мой телефон"))

        }

        bb ()

    }


}