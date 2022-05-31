package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.ListOfApplicationsAllFragmentBinding
import com.bignerdranch.android.quasar.fragment.equipment.Equipment
import com.bignerdranch.android.quasar.ui.viewmodel.application.ListOfApplicationsAllViewModel

class ListOfApplicationsAll : Fragment() {

    companion object {
        fun newInstance() = ListOfApplicationsAll()
    }

    private lateinit var viewModel: ListOfApplicationsAllViewModel
lateinit var bindingListOfApplicationsAll: ListOfApplicationsAllFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingListOfApplicationsAll= DataBindingUtil.inflate(inflater, R.layout.list_of_applications_all_fragment,container,false)
        return bindingListOfApplicationsAll.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfApplicationsAllViewModel::class.java)
        MainActivity.menu.visibility = VISIBLE

bindingListOfApplicationsAll.imgApplicationsAllPlus.setOnClickListener{
    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, Application.newInstance()).addToBackStack(null).commit()
}

        bindingListOfApplicationsAll.imgApplicationsAllPlus.setOnClickListener{
            CreatingApplicationDialog().show(fragmentManager!!, "d")
        }
    }

}