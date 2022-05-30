package com.bignerdranch.android.quasar.ui.viewmodel.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R

class RecoveryCodeViewModel : ViewModel() {

    companion object{
        var trueFalseErrorCode = ""
    }

    fun openNewTabWindowCode(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

    fun backBtnCode(txtRecoveryCodeEnterTheCode: EditText, btnRecoveryCodeLogInToTheSystem: TextView){
        if(txtRecoveryCodeEnterTheCode.text.toString() == ""){
            btnRecoveryCodeLogInToTheSystem.setBackgroundResource(R.drawable.ic_back_btn_grey)
        }else{
            btnRecoveryCodeLogInToTheSystem.setBackgroundResource(R.drawable.ic_back_btn_blue)
        }
    }

    fun errorClickCode(txtRecoveryCodeEnterTheCode: EditText, txtRecoveryCodeError: TextView){
        var whitespaceCode = " "
        if(txtRecoveryCodeEnterTheCode.text.toString().contains(whitespaceCode)){
            txtRecoveryCodeError.visibility = View.VISIBLE
            txtRecoveryCodeError.text = "Введен неверный код"
            trueFalseErrorCode = "true"
        }else{
            txtRecoveryCodeError.visibility = View.GONE
            trueFalseErrorCode = "false"
        }
    }
}