package com.bignerdranch.android.quasar.ui.viewmodel.application

import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.bignerdranch.android.quasar.R

class ApplicationChatViewModel : ViewModel() {

    companion object{
        var msgTrueFale = false
    }

    fun clickMsg(txtApplicationChatMsg: EditText){
        if(txtApplicationChatMsg.text.toString() == ""){
            msgTrueFale = false
        }else{
            msgTrueFale = true
        }
    }
}