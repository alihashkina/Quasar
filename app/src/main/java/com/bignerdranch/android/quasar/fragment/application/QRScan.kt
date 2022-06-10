package com.bignerdranch.android.quasar.fragment.application

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bignerdranch.android.quasar.MainActivity
import com.bignerdranch.android.quasar.R
import com.bignerdranch.android.quasar.databinding.QRScanFragmentBinding
import com.bignerdranch.android.quasar.ui.viewmodel.application.QRScanViewModel
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import org.json.JSONObject

class QRScan : Fragment() {

    companion object {
        fun newInstance() = QRScan()
    }

    private lateinit var viewModel: QRScanViewModel
   lateinit var bindingQRScan: QRScanFragmentBinding

    var handler = Handler(Looper.getMainLooper())
    private lateinit var codeScanner: CodeScanner
    var result: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingQRScan= DataBindingUtil.inflate(inflater, R.layout.q_r_scan_fragment,container,false)
        return bindingQRScan.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(QRScanViewModel::class.java)
        MainActivity.menu.visibility = GONE
        bindingQRScan.txtQRSacnBack.setOnClickListener {
            if (ApplicationEdit.qrFragmentBack.contains("CreatingApplicationDialog")) {
                CreatingApplicationDialog().show(fragmentManager!!, "d")
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.containerView, ListOfApplicationsAll.newInstance())
                    .addToBackStack(null).commit()
            } else {
                ApplicationEdit().show(fragmentManager!!, "d")
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.containerView, Application.newInstance()).addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun checkPermission(){
        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                startScanning()
                Log.i("My", "scan first")
            } else {
                Log.i("My", "scan no")
            }
        }
        when {
            ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                startScanning()
                Log.i("My", "scan")
            }
            else -> {
                requestPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun startScanning() {
        codeScanner = CodeScanner(requireContext() ,bindingQRScan.codeScannerView)
        codeScanner.camera = CodeScanner.CAMERA_BACK
        codeScanner.formats = CodeScanner.ALL_FORMATS

        codeScanner.autoFocusMode = AutoFocusMode.SAFE
        codeScanner.scanMode = ScanMode.SINGLE
        codeScanner.isAutoFocusEnabled = true
        codeScanner.isFlashEnabled = false

        codeScanner.decodeCallback = DecodeCallback {
            try {
                 if (ApplicationEdit.qrFragmentBack.contains("CreatingApplicationDialog")) {
                    CreatingApplicationDialog.newInstance(it.toString()).show(fragmentManager!!, "d")
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.containerView, ListOfApplicationsAll.newInstance())
                        .addToBackStack(null).commit()
                } else {
                    ApplicationEdit.newInstance(it.toString()).show(fragmentManager!!, "d")
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.containerView, Application.newInstance()).addToBackStack(null)
                        .commit()
                }
            }

            catch (e: Exception){

            }
        }

        codeScanner.errorCallback = ErrorCallback {
        }


            codeScanner.startPreview()

    }


    override fun onResume() {
        super.onResume()
        if(::codeScanner.isInitialized){
            codeScanner?.startPreview()
        }
    }

    override fun onPause() {
        super.onPause()
        if(::codeScanner.isInitialized){
            codeScanner?.releaseResources()
        }
    }

}