package com.amanullah.tukitalki.services.user

import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.inject.Inject

class UserServiceImpl @Inject constructor(private val dbref: FirebaseDatabase)  : UserService {
    override suspend fun createUser(request: RequestUserRegister): Task<Void> {

        // val v= dbref.reference.child("user").child(request.userId).setValue(request)

        return dbref.reference.child("user").child(request.userId).setValue(request)
    }

    override suspend fun getUserById(userId: String): DatabaseReference {
        return dbref.reference.child("user").child(userId)
    }

    override suspend fun getUserAllUser(): DatabaseReference {
        return  dbref.reference.child("user")
    }
}