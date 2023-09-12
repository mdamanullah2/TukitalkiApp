package com.amanullah.tukitalki.services.auth

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {
    suspend fun register(request: RequestUserRegister): Task<AuthResult>
    suspend fun login(request: RequestUserLogin): Task<AuthResult>
}