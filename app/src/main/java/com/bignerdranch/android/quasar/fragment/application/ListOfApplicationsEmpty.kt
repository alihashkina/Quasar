package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.application.ListOfApplicationsEmptyViewModel

class ListOfApplicationsEmpty : Fragment() {

    companion object {
        fun newInstance() = ListOfApplicationsEmpty()
    }

    private lateinit var emptyViewModel: ListOfApplicationsEmptyViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_of_applications_empty_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        emptyViewModel = ViewModelProvider(this).get(ListOfApplicationsEmptyViewModel::class.java)
        // TODO: Use the ViewModel


    }
}