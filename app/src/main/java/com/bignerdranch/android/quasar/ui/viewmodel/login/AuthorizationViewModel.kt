package com.bignerdranch.android.quasar.ui.viewmodel.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.adapters.TextViewBindingAdapter.getTextString
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.fragment.MainFragment
import com.bignerdranch.android.quasar.fragment.application.ListOfApplicationsEmpty
import com.bignerdranch.android.quasar.fragment.login.Authorization
import com.bignerdranch.android.quasar.retrofit.common.Common
import com.bignerdranch.android.quasar.retrofit.model.Service
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Base64

class AuthorizationViewModel : ViewModel() {

    companion object{
        var flagDrawablePassword = true
        var trueFalseBackBtn = ""
        var trueFalseErrorLogin = ""
        var tokenAuth: String = ""
        var auth = 0
    }

    fun openNewTabWindowAuth(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

    fun backBtnAuth(txtAuthorizationLogin: EditText, txtAuthorizationPassword: EditText, btnAuthorizationLogin: TextView){
        var flagtxtAuthorizationLogin = "false"
        var flagtxtAuthorizationPassword = "false"

          if (txtAuthorizationLogin.text.toString() == "") {
                flagtxtAuthorizationLogin = "false"
            } else {
                flagtxtAuthorizationLogin = "true"
            }

            if (txtAuthorizationPassword.text.toString() == "") {
                flagtxtAuthorizationPassword = "false"
            } else {
                flagtxtAuthorizationPassword = "true"
            }

        trueFalseBackBtn = flagtxtAuthorizationLogin + flagtxtAuthorizationPassword
        Log.i("LLLL", "${trueFalseBackBtn}")
            if (trueFalseBackBtn.contains("false")) {
                btnAuthorizationLogin.setBackgroundResource(R.drawable.ic_back_btn_grey)
                btnAuthorizationLogin.isClickable = false
            } else {
                btnAuthorizationLogin.setBackgroundResource(R.drawable.ic_back_btn_blue)
                btnAuthorizationLogin.isClickable = true
            }
    }


    fun drawablePassword(imgAuthorizationPassword: ImageView, txtAuthorizationPassword: EditText){
        if(!flagDrawablePassword){
            imgAuthorizationPassword.setImageResource(R.drawable.ic_password_no)
            txtAuthorizationPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            flagDrawablePassword = true
        }else{
            imgAuthorizationPassword.setImageResource(R.drawable.ic_password_yes)
            txtAuthorizationPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            flagDrawablePassword = false
        }
    }

    fun errorClickAuth(txtAuthorizationLogin: EditText, txtAuthorizationPassword: EditText, btnAuthorizationLogin: TextView, txtAuthorizationLoginError: TextView, txtAuthorizationPasswordError: TextView){
        Log.i("logi", "3")
        var whitespace = " "
        var flagErrorClickLogin = "false"
        var flagErrorClickPassword = "false"
        if (txtAuthorizationLogin.text.toString().contains(whitespace)){
            txtAuthorizationLoginError.visibility = VISIBLE
            txtAuthorizationLoginError.text = "Введен недопустимый символ"
            flagErrorClickLogin = "true"
        }else{
            txtAuthorizationLoginError.visibility = GONE
            flagErrorClickLogin = "false"
        }
        if (txtAuthorizationPassword.text.toString().contains(whitespace)){
            txtAuthorizationPasswordError.visibility = VISIBLE
            txtAuthorizationPasswordError.text = "Введен недопустимый символ"
            flagErrorClickPassword = "true"
        }else {
            txtAuthorizationPasswordError.visibility = GONE
            flagErrorClickPassword = "false"
        }

        if(txtAuthorizationLogin.text.toString() == ""){
            flagErrorClickLogin = "true"
        }
        if(txtAuthorizationPassword.text.toString() == ""){
            flagErrorClickPassword = "true"
        }

        trueFalseErrorLogin = flagErrorClickLogin + flagErrorClickPassword
        Log.i("LLLLq", "${trueFalseErrorLogin}")
        if (trueFalseErrorLogin.contains("true")) {
            trueFalseErrorLogin = "true"
        }else{
            trueFalseErrorLogin = "false"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun code(txtAuthorizationLogin: EditText, txtAuthorizationPassword: EditText) {
        val loginPassword = "${txtAuthorizationLogin.text}:${txtAuthorizationPassword.text}"
        val encodedString: String = Base64.getEncoder().encodeToString(loginPassword.toByteArray())
         tokenAuth = "Basic ${encodedString}"
        Log.i("encodedString", "${tokenAuth}")
        Log.i("logi", "1")
    }

    fun task (txtAuthorizationPasswordError: TextView) {
        Common.retrofitService.task("${tokenAuth}").enqueue(object: Callback<Service> {
            override fun onResponse(call: Call<Service>, response: Response<Service>) {
                Log.i("response.code()", "" + response.code())
                auth = response.code()
                Log.i("MyLogtask", "NOT ERROR AuthLogin" + response.body())
            }
            override fun onFailure(call: Call<Service>, t: Throwable) {
                Log.i("MyLogtask", "ERROR AuthLogin" + t)
            }
        })
    }

    fun errorAuth(txtAuthorizationPasswordError: TextView){
        if(auth in 500..504){
            txtAuthorizationPasswordError.visibility = VISIBLE
            txtAuthorizationPasswordError.text = "Нет соединения с сервером"
        }else{
            txtAuthorizationPasswordError.visibility = VISIBLE
            txtAuthorizationPasswordError.text = "Неверный логин или пароль"
        }

    }

}