package com.bignerdranch.android.quasar.fragment.application

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.bignerdranch.android.quasar.R
import org.json.JSONException
import org.json.JSONObject

//class Scanner: Fragment() {
//
//    internal var qrScanIntegrator: IntentIntegrator? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        qrScanIntegrator = IntentIntegrator(requireActivity())
//        qrScanIntegrator?.setOrientationLocked(false)
//
//        qrScanIntegrator?.setPrompt("getString")
//        qrScanIntegrator?.setCameraId(0)
//        qrScanIntegrator?.setBeepEnabled(true)
//        qrScanIntegrator?.setBarcodeImageEnabled(true)
//
//        performAction()
//    }
//    private fun performAction() {
//        qrScanIntegrator?.initiateScan()
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        if (result != null) {
//            if (result.contents == null) {
//                Log.i("s", "getString(R.string.result_not_found)")
//            } else {
//                try {
//                    val obj = JSONObject(result.contents)
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                    Log.i("s", "contents")
//                }
//
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
//}