package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ListOfApplicationsEmptyFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.ListOfApplicationsEmptyViewModel

class ListOfApplicationsEmpty : Fragment() {

    companion object {
        fun newInstance() = ListOfApplicationsEmpty()
    }

    private lateinit var emptyViewModel: ListOfApplicationsEmptyViewModel
lateinit var bindingListOfApplicationsEmpty: ListOfApplicationsEmptyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingListOfApplicationsEmpty= DataBindingUtil.inflate(inflater, R.layout.list_of_applications_empty_fragment,container,false)
        return bindingListOfApplicationsEmpty.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        emptyViewModel = ViewModelProvider(this).get(ListOfApplicationsEmptyViewModel::class.java)
        bindingListOfApplicationsEmpty.btnApplicationsApplicationsCreate.setOnClickListener{
            findNavController().navigate(R.id.creatingApplicationDialog2)
        }

bindingListOfApplicationsEmpty.imgApplicationsPlus.setOnClickListener{
    findNavController().navigate(R.id.creatingApplicationDialog2)
}
    }
}