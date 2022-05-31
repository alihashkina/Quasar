package com.bignerdranch.android.quasar

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.get
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.fragment.MainFragment
import com.bignerdranch.android.quasar.fragment.Menu
import com.bignerdranch.android.quasar.fragment.application.ListOfApplicationsEmpty
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.fragment.equipment.ListEquipment
import com.bignerdranch.android.quasar.fragment.login.Authorization
import com.bignerdranch.android.quasar.fragment.settingprofile.GeneralPage
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var menu: BottomNavigationView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        menu = findViewById(R.id.main_bottom_menu)
        menu.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.listOfApplications -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsEmpty.newInstance()).addToBackStack(null).commit()
                }
                R.id.listEquipment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
                }
                R.id.generalPage -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
                }

            }
            true
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.containerView, Authorization.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.listOfApplications -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsEmpty.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//            R.id.listEquipment -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//            R.id.generalPage -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

}