package com.amanullah.tukitalki.services

import com.amanullah.tukitalki.data.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {
    suspend fun register(request:RequestUserRegister): Task<AuthResult>
}