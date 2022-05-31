package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R

class ApplicationEditViewModel : ViewModel() {
    companion object{
        var trueFalseClickApplicationEdit= ""
    }

    fun backBtnApplicationEdit(txtApplicationEditComm: EditText, btnApplicationEditSave: TextView){
        if(txtApplicationEditComm.text.toString() == ""){
            btnApplicationEditSave.setBackgroundResource(R.drawable.ic_back_btn_grey)
            trueFalseClickApplicationEdit = "false"
        }else{
            btnApplicationEditSave.setBackgroundResource(R.drawable.ic_back_btn_blue)
            trueFalseClickApplicationEdit = "true"
        }
    }
}