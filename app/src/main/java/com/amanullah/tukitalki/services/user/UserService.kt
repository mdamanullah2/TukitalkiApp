package com.amanullah.tukitalki.services.user

import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference

interface UserService {
    suspend fun createUser(request: RequestUserRegister): Task<Void>
    suspend fun getUserById(userId: String): DatabaseReference
    suspend fun getUserAllUser(): DatabaseReference

}