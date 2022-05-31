package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R

class CreatingApplicationDialogViewModel : ViewModel() {

    companion object{
        var trueFalseClickCreatingApplicationDialog = ""
    }

    fun backBtnCreatingApplicationDialog(txtCreatingApplicationDialogComm: EditText, btnCreatingApplicationDialogCreateApplication: TextView){
        if(txtCreatingApplicationDialogComm.text.toString() == ""){
            btnCreatingApplicationDialogCreateApplication.setBackgroundResource(R.drawable.ic_back_btn_grey)
            trueFalseClickCreatingApplicationDialog = "false"
        }else{
            btnCreatingApplicationDialogCreateApplication.setBackgroundResource(R.drawable.ic_back_btn_blue)
            trueFalseClickCreatingApplicationDialog = "true"
        }
    }
}