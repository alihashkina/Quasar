package com.bignerdranch.android.quasar.fragment.settingprofile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.ui.viewmodel.settingprofile.EditPasswordViewModel

class EditPassword : Fragment() {

    companion object {
        fun newInstance() = EditPassword()
    }

    private lateinit var viewModel: EditPasswordViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.edit_password_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EditPasswordViewModel::class.java)
        // TODO: Use the ViewModel

    }

}