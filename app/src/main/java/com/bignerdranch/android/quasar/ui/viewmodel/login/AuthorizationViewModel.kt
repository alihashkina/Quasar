package com.bignerdranch.android.quasar.ui.viewmodel.login

import android.content.Context
import android.content.Intent
import android.net.Uri
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
import androidx.constraintlayout.motion.widget.Key.VISIBILITY
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.fragment.MainFragment

class AuthorizationViewModel : ViewModel() {

    companion object{
        var flagDrawablePassword = true
        var trueFalseBackBtn = ""
        var trueFalseErrorLogin = ""
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
        }else{
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

}