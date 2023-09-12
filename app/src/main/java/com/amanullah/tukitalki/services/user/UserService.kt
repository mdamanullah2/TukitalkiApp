package com.amanullah.tukitalki.services.user

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface UserService {
    suspend fun createUser(request: RequestUserRegister): Task<Void>

}