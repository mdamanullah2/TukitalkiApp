package com.amanullah.tukitalki.services.auth

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthServiceImpl @Inject constructor (private val auth:FirebaseAuth): AuthService {

    override suspend fun register(request: RequestUserRegister): Task<AuthResult> {

        return this.auth.createUserWithEmailAndPassword(request.email, request.password)
    }

    override suspend fun login(request: RequestUserLogin): Task<AuthResult> {

        return auth.signInWithEmailAndPassword(request.email, request.password)
    }
}