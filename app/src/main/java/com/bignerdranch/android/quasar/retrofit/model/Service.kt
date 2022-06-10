package com.bignerdranch.android.quasar.retrofit.model

data class Service (
    var Id: Int,
    val Code: String,
    val Name: String,
    val Description: String,
    val IsArchive: Boolean,
    val IsPublic: Boolean,
    val ParentId: Int,
    val Path: String,
    val CanCreateTask: Boolean,
    val HasTaskTypes: Boolean
        )