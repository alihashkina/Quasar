package com.bignerdranch.android.quasar.ui.viewmodel.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding
import com.bignerdranch.android.quasar.fragment.MainFragment

class AuthorizationViewModel : ViewModel() {

    companion object{
        var flagDrawablePassword = true
    }

    fun openNewTabWindow(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

    fun backBtn(txtAuthorizationLogin: EditText, txtAuthorizationPassword: EditText, btnAuthorizationLogin: TextView){
        var whitespace = " "
        var flagtxtAuthorizationLogin = ""
        var flagtxtAuthorizationPassword = ""

        while(txtAuthorizationPassword.toString().isEmpty()) {
            if (txtAuthorizationLogin.text.contains(whitespace)) {
                flagtxtAuthorizationLogin = "false"
            } else {
                flagtxtAuthorizationLogin = "true"
            }

            if (txtAuthorizationPassword.text.contains(whitespace)) {
                flagtxtAuthorizationPassword = "false"
            } else {
                flagtxtAuthorizationPassword = "true"
            }

            var trueFalse = flagtxtAuthorizationLogin + flagtxtAuthorizationPassword
            if (trueFalse.contains("false")) {
                btnAuthorizationLogin.setBackgroundResource(R.drawable.ic_back_btn_grey)
                btnAuthorizationLogin.isClickable = false
            } else {
                btnAuthorizationLogin.setBackgroundResource(R.drawable.ic_back_btn_blue)
                btnAuthorizationLogin.isClickable = true
            }
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

}