package com.amanullah.tukitalki.data

data class RequestUserRegister(
    var userid:String="",
    val name:String,
    val email:String,
    val password:String
)
