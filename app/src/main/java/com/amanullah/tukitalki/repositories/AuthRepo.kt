package com.amanullah.tukitalki.repositories

import com.amanullah.tukitalki.data.RequestUserRegister
import com.amanullah.tukitalki.services.AuthServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class AuthRepo @Inject constructor(private var authService: AuthServiceImpl) {

    suspend fun registration(requestUserRegister: RequestUserRegister): Task<AuthResult> {

       return authService.register(requestUserRegister)
    }


}