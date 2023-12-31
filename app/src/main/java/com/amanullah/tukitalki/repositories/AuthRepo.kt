package com.amanullah.tukitalki.repositories

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.services.auth.AuthServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class AuthRepo @Inject constructor(private var authService: AuthServiceImpl) {

    suspend fun registration(requestUserRegister: RequestUserRegister): Task<AuthResult> {
       return authService.register(requestUserRegister)
    }

    suspend fun login(request: RequestUserLogin): Task<AuthResult> {
        return authService.login(request)
    }

}