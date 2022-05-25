package com.bignerdranch.android.quasar.fragment.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.MainActivity

import android.content.Intent
import androidx.databinding.DataBindingUtil
import com.bignerdranch.android.quasar.databinding.ActivitySplashScreenBinding
import com.bignerdranch.android.quasar.databinding.AuthorizationFragmentBinding


class SplashScreen : AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}