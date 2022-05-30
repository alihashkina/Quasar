package com.bignerdranch.android.quasar.retrofit.common

import com.bignerdranch.android.quasar.retrofit.RetrofitClient
import com.bignerdranch.android.quasar.retrofit.RetrofitServieces

object Common {
    private val BASE_URL = "https://quasartest.intraservice.ru/api/"
    val retrofitService: RetrofitServieces
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServieces::class.java)
}