package com.bignerdranch.android.quasar.fragment.application

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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
        bindingQRScan.txtQRSacnBack.setOnClickListener{
            findNavController().navigate(R.id.applicationEdit)
        }

    }

}