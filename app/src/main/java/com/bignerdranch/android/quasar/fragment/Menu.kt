package com.bignerdranch.android.quasar.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bignerdranch.android.quasar.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class Menu : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        var menu = view.findViewById<BottomNavigationView>(R.id.menu)
//        var nav =
//            (childFragmentManager.findFragmentById(R.id.containerMenu) as NavHostFragment).navController
//        NavigationUI.setupWithNavController(menu, nav)
    }
}