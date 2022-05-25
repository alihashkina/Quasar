package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.application.ListOfApplicationsAllViewModel

class ListOfApplicationsAll : Fragment() {

    companion object {
        fun newInstance() = ListOfApplicationsAll()
    }

    private lateinit var viewModel: ListOfApplicationsAllViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_of_applications_all_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfApplicationsAllViewModel::class.java)
        // TODO: Use the ViewModel

    }

}