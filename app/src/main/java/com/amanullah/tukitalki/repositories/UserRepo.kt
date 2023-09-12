package com.amanullah.tukitalki.repositories

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.services.auth.AuthServiceImpl
import com.amanullah.tukitalki.services.user.UserService
import com.amanullah.tukitalki.services.user.UserServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class UserRepo @Inject constructor(private var service: UserServiceImpl) {

    suspend fun createUser(requestUserRegister: RequestUserRegister): Task<Void> {

        return service.createUser(requestUserRegister)
    }
}