package com.amanullah.tukitalki.repositories


import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.services.user.UserServiceImpl
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class UserRepo @Inject constructor(private var service: UserServiceImpl) {

    suspend fun createUser(requestUserRegister: RequestUserRegister): Task<Void> {

        return service.createUser(requestUserRegister)
    }

    suspend fun getUserById(userId: String): DatabaseReference{
        return service.getUserById(userId)
    }

    suspend fun getAllUser(): DatabaseReference{
        return service.getUserAllUser()
    }

}