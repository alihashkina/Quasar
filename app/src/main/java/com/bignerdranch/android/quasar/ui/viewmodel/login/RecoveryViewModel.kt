package com.bignerdranch.android.quasar.ui.viewmodel.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R

class RecoveryViewModel : ViewModel() {
    companion object{
        var trueFalseErrorEmail = ""
    }

    fun openNewTabWindowEmail(urls: String, context: Context) {
        val uris = Uri.parse(urls)
        val intents = Intent(Intent.ACTION_VIEW, uris)
        val b = Bundle()
        b.putBoolean("new_window", true)
        intents.putExtras(b)
        context.startActivity(intents)
    }

    fun backBtnEmail(txtRecoveryEmail: EditText, btnRecoverySendTheCodeToTheMail: TextView){
        if(txtRecoveryEmail.text.toString() == ""){
            btnRecoverySendTheCodeToTheMail.setBackgroundResource(R.drawable.ic_back_btn_grey)
        }else{
            btnRecoverySendTheCodeToTheMail.setBackgroundResource(R.drawable.ic_back_btn_blue)
        }
        }

    fun errorClickEmail(txtRecoveryEmail: EditText, txtRecoveryEmailError: TextView){
if(Patterns.EMAIL_ADDRESS.matcher(txtRecoveryEmail.text).matches()){
    txtRecoveryEmailError.visibility = GONE
    trueFalseErrorEmail = "false"
}else{
    txtRecoveryEmailError.visibility = VISIBLE
    txtRecoveryEmailError.text = "Введен некорректный адрес почты"
    trueFalseErrorEmail = "true"
}
    }


}