package com.bignerdranch.android.quasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.fragment.MainFragment
import com.bignerdranch.android.quasar.fragment.Menu
import com.bignerdranch.android.quasar.fragment.login.Authorization

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .add(R.id.container, Authorization.newInstance())
//                .addToBackStack(null)
//                .commit()
//        }
    }
}