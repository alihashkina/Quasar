package com.bignerdranch.android.quasar.fragment.application

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
import com.bignerdranch.android.quasar.databinding.QRScanFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.QRScanViewModel

class QRScan : Fragment() {

    companion object {
        fun newInstance() = QRScan()
    }

    private lateinit var viewModel: QRScanViewModel
    lateinit var bindingQRScan: QRScanFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingQRScan= DataBindingUtil.inflate(inflater, R.layout.q_r_scan_fragment,container,false)
        return bindingQRScan.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QRScanViewModel::class.java)
        MainActivity.menu.visibility = GONE

        bindingQRScan.txtQRSacnBack.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsAll.newInstance()).addToBackStack(null).commit()
        }


    }

}