package com.bignerdranch.android.quasar.fragment.settingprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.EditPasswordFragmentBinding
import com.bignerdranch.android.quasar.fragment.application.CreatingApplicationDialog
import com.bignerdranch.android.quasar.ui.viewmodel.settingprofile.EditPasswordViewModel

class EditPassword : Fragment() {

    companion object {
        fun newInstance() = EditPassword()
    }

    private lateinit var viewModel: EditPasswordViewModel
    lateinit var bindingEditPassword: EditPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingEditPassword= DataBindingUtil.inflate(inflater, R.layout.edit_password_fragment,container,false)
        return bindingEditPassword.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditPasswordViewModel::class.java)
        MainActivity.menu.visibility = GONE

        bindingEditPassword.txtEditPasswordBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
        }
    }

}