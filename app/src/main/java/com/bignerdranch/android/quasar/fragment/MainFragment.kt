package com.bignerdranch.android.quasar.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.fragment.login.Authorization
import com.bignerdranch.android.quasar.fragment.login.UserAgreement
import com.bignerdranch.android.quasar.ui.viewmodel.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

//        var menu = view!!.findViewById<BottomNavigationView>(R.id.main_bottom_menu)
//        var navC =
//            (childFragmentManager.findFragmentById(R.id.containerViewMain) as NavHostFragment).navController
//        NavigationUI.setupWithNavController(menu, navC)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        childFragmentManager.beginTransaction()
//            .replace(R.id.containerViewMain, Authorization.newInstance())
//            .addToBackStack(null)
//            .commit()
//        var menu = view.findViewById<BottomNavigationView>(R.id.main_bottom_menu)
//        var navC =
//            (childFragmentManager.findFragmentById(R.id.containerViewMain2) as NavHostFragment).navController
//        NavigationUI.setupWithNavController(menu, navC)
    }

}