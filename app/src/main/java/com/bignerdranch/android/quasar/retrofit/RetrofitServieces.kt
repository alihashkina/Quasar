package com.bignerdranch.android.quasar.retrofit

import com.bignerdranch.android.quasar.retrofit.model.Authorization
import com.bignerdranch.android.quasar.retrofit.model.Companydocument
import com.bignerdranch.android.quasar.retrofit.model.Service
import com.bignerdranch.android.quasar.retrofit.model.Taskexecutorgroup
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitServieces {
//    @GET("auth")
//    fun auth(@Header("Authorization") Token: String): Call<JSONObject>

    @POST("token")
    fun token(@Header("Authorization") Token: String, @Body authorization: Authorization): Call<Void>

    @GET("task?page=2&pagesize=10")
    fun bb(@Header("Authorization") Token: String): Call<JSONObject>

    @GET("service")
        fun task(@Header("Authorization") Token: String): Call<Service>

        @GET("taskexecutorgroup")
        fun taskexecutorgroup (@Header("Authorization") Token: String): Call<Taskexecutorgroup>

        @GET("companydocument")
        fun companydocument (@Header("Authorization") Token: String): Call<JSONObject>

}