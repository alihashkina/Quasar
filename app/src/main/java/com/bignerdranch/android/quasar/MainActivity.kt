package com.bignerdranch.android.quasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bignerdranch.android.quasar.fragment.application.Application
import com.bignerdranch.android.quasar.fragment.application.ListOfApplicationsEmpty
import com.bignerdranch.android.quasar.fragment.equipment.ListEquipment
import com.bignerdranch.android.quasar.fragment.login.Authorization
import com.bignerdranch.android.quasar.fragment.settingprofile.GeneralPage
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    companion object{
        lateinit var menu: BottomNavigationView
        var fragmentMenu: String = ""

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        menu = findViewById(R.id.main_bottom_menu)
        menu.setOnNavigationItemSelectedListener {
            item ->
            when (item.itemId) {
                R.id.listOfApplications -> {
                        supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsEmpty.newInstance()).addToBackStack(null).commit()
                }
                R.id.listEquipment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
                }
                R.id.generalPage -> {
                    supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
                }

            }
            true
        }


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.containerView, Application.newInstance())
               // .add(R.id.containerView, Authorization.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }


//    fun performAction() {
//        qrScanIntegrator?.initiateScan()
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
//        if (result != null) {
//            if (result.contents == null) {
//                Log.i("qr", "--------")
//            } else {
//                try {
//                    val obj = JSONObject(result.contents)
//                } catch (e: JSONException) {
//                    e.printStackTrace()
////                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
//                }
//
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }

//     fun checkCameraPermission() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                Manifest.permission.CAMERA
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            Intent().also {
//                it.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
//                it.data = Uri.fromParts("package", packageName, null)
//                startActivity(it)
//                finish()
//            }
//        }
//    }
//
//    @SuppressLint("UnsafeExperimentalUsageError")
//     fun bindPreview(cameraProvider: ProcessCameraProvider, previewView: PreviewView) {
//        val preview: Preview = Preview.Builder()
//            .build()
//        val cameraSelector: CameraSelector = CameraSelector.Builder()
//            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
//            .build()
//        preview.setSurfaceProvider(previewView.createSurfaceProvider(null))
//
//        val imageAnalysis = ImageAnalysis.Builder()
//            .setTargetResolution(Size(1280 ,720))
//            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//            .build()
//     //   imageAnalysis.setAnalyzer(cameraExecutor, analyzer)
//
//        cameraProvider.bindToLifecycle(
//            this as LifecycleOwner,
//            cameraSelector,
//            imageAnalysis,
//            preview
//        )
//
//    }

//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        when (item.itemId) {
//            R.id.listOfApplications -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, ListOfApplicationsEmpty.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//            R.id.listEquipment -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, ListEquipment.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//            R.id.generalPage -> {
//                supportFragmentManager.beginTransaction().replace(R.id.containerView, GeneralPage.newInstance()).addToBackStack(null).commit()
//                return true
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

}