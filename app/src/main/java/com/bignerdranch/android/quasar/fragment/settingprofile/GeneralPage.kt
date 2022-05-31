package com.bignerdranch.android.quasar.fragment.settingprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.GeneralPageFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.settingprofile.GeneralPageViewModel

class GeneralPage : Fragment() {

    companion object {
        fun newInstance() = GeneralPage()
    }

    private lateinit var viewModel: GeneralPageViewModel
    lateinit var bindingGeneralPage: GeneralPageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingGeneralPage= DataBindingUtil.inflate(inflater, R.layout.general_page_fragment,container,false)
        return bindingGeneralPage.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GeneralPageViewModel::class.java)

        MainActivity.menu.visibility = VISIBLE

    }

}