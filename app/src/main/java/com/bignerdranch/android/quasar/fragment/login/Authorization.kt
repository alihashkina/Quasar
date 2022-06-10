package com.bignerdranch.android.quasar.fragment.login

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.Bindable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.CreatingApplicationDialog
import com.bignerdranch.android.quasar.fragment.application.ListOfApplicationsEmpty
import com.bignerdranch.android.quasar.retrofit.common.Common
import com.bignerdranch.android.quasar.retrofit.model.Companydocument
import com.bignerdranch.android.quasar.retrofit.model.Service
import com.bignerdranch.android.quasar.retrofit.model.Taskexecutorgroup
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel.Companion.auth
import com.bignerdranch.android.quasar.ui.viewmodel.login.AuthorizationViewModel.Companion.tokenAuth
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Authorization : Fragment() {

    companion object {
        fun newInstance() = Authorization()
    }

    private lateinit var viewModel: AuthorizationViewModel
lateinit var bindingAuthorization: AuthorizationFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindingAuthorization= DataBindingUtil.inflate(inflater, R.layout.authorization_fragment,container,false)
        return bindingAuthorization.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AuthorizationViewModel::class.java)
        MainActivity.menu.visibility = GONE

        bindingAuthorization.txtAuthorizationTermsOfUse.setOnClickListener {
            viewModel.openNewTabWindowAuth("https://www.dropbox.com/s/hkp5i4bbcaux9k9/", context!!)
        }

        bindingAuthorization.txtAuthorizationYouDontHaveAccess.setOnClickListener {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, Recovery.newInstance()).addToBackStack(null).commit()
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
                viewModel.code(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword)
                viewModel.task(bindingAuthorization.txtAuthorizationPasswordError)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

//        fun authh(authorization: com.bignerdranch.android.quasar.retrofit.model.Authorization){
//            Common.retrofitService.token("${tokenAuth}", authorization).enqueue(object: Callback<Void> {
//
//                override fun onResponse(call: Call<Void>, response: Response<Void>) {
//                    Log.d("MyLoge", "callback AnonimToken" + response)
//                }
//
//                override fun onFailure(call: Call<Void>, t: Throwable) {
//                    Log.d("MyLoge", "ERRRRRORRR TOKEN")
//                }
//            })
//        }

//        fun bb () {
//            Common.retrofitService.bb("${tokenAuth}").enqueue(object: Callback<JSONObject>{
//                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
//                    // googleName()
//
//                    Log.i("MyLogbb", "NOT ERROR AuthLogin" + response)
//                }
//
//                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
//                    Log.i("MyLogbb", "ERROR AuthLogin" + t)
//                }
//            })
//
//        }

//        fun auth () {
//            Common.retrofitService.auth("${tokenAuth}").enqueue(object: Callback<JSONObject>{
//                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
//                    // googleName()
//
//                    Log.i("MyLogauth", "NOT ERROR AuthLogin" + response)
//                }
//
//                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
//                    Log.i("MyLogauth", "ERROR AuthLogin" + t)
//                }
//            })
//
//        }

//        fun taskexecutorgroup () {
//            Common.retrofitService.taskexecutorgroup("${tokenAuth}").enqueue(object: Callback<Taskexecutorgroup>{
//                override fun onResponse(call: Call<Taskexecutorgroup>, response: Response<Taskexecutorgroup>) {
//                    // googleName()
//
//                    Log.i("MyLogtaskexecutorgroup", "NOT ERROR AuthLogin" + response.body())
//                }
//
//                override fun onFailure(call: Call<Taskexecutorgroup>, t: Throwable) {
//                    Log.i("MyLogtaskexecutorgroup", "ERROR AuthLogin" + t)
//                }
//            })
//
//        }
//
//        fun companydocument () {
//            Common.retrofitService.companydocument("${tokenAuth}").enqueue(object: Callback<JSONObject>{
//                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
//                    // googleName()
//
//                    Log.i("MyLogCompanydocument", "NOT ERROR AuthLogin" + response.body())
//                }
//
//                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
//                    Log.i("MyLogCompanydocument", "ERROR AuthLogin" + t)
//                }
//            })
//
//        }

        bindingAuthorization.imgAuthorizationPassword.setOnClickListener{
           viewModel.drawablePassword(bindingAuthorization.imgAuthorizationPassword, bindingAuthorization.txtAuthorizationPassword)
        }

        bindingAuthorization.btnAuthorizationLogin.setOnClickListener {
           Log.i("task1", "${auth}")
             Log.i("task2", "${auth}")
            viewModel.errorClickAuth(bindingAuthorization.txtAuthorizationLogin, bindingAuthorization.txtAuthorizationPassword, bindingAuthorization.btnAuthorizationLogin, bindingAuthorization.txtAuthorizationLoginError, bindingAuthorization.txtAuthorizationPasswordError)
            if(AuthorizationViewModel.trueFalseErrorLogin.contains("false")) {
                  Log.i("dsssssss", "${auth}")
            }
            if(auth in 200..226){
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsEmpty.newInstance()).addToBackStack(null).commit()
            }else{
                viewModel.errorAuth(bindingAuthorization.txtAuthorizationPasswordError)
            }
        }

    }


}