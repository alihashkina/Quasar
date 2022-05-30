package com.bignerdranch.android.quasar.retrofit

import com.bignerdranch.android.quasar.retrofit.model.Authorization
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface RetrofitServieces {
    @POST("authorization")
    fun auth(@Body authorization: Authorization): Call<JSONObject>

    @POST("token")
    fun nn(@Body authorization: Authorization): Call<JSONObject>

    @GET("task?page=2&pagesize=10")
    fun bb(@Header("Authorization") Token: String): Call<JSONObject>
}