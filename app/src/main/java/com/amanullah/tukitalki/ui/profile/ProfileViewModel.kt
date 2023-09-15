package com.amanullah.tukitalki.ui.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.data.user.UserProfile
import com.amanullah.tukitalki.repositories.AuthRepo
import com.amanullah.tukitalki.repositories.UserRepo
import com.amanullah.tukitalki.utils.ErrorMessage
import com.amanullah.tukitalki.utils.SuccessMessage
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepo: UserRepo):ViewModel(){

    private var _response=MutableLiveData<UserProfile>()
    val responseProfile :LiveData<UserProfile> = _response

    //Comment on function

    fun getUserById(userId:String){
         viewModelScope.launch {
             userRepo.getUserById(userId).addValueEventListener(object : ValueEventListener{
                 override fun onDataChange(snapshot: DataSnapshot) {
                     val value= snapshot.getValue(UserProfile::class.java)

                     value?.let {
                         _response.postValue(it)
                     }

                 }

                 override fun onCancelled(error: DatabaseError) {
                     Log.w("TAG","Failed to read value", error.toException())
                 }
             })
         }

    }

    private var _responseAllUser = MutableLiveData<List<UserProfile>>()
    val responseAllUserProfile :LiveData<List<UserProfile>> = _responseAllUser

    //Comment on function

    fun getAllUser(){

        val userList = mutableListOf<UserProfile>()

        viewModelScope.launch {
            userRepo.getAllUser().addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    userList.clear()

                    snapshot.children.forEach { dataSnapshot ->

                        val value= dataSnapshot.getValue(UserProfile::class.java)

                        value?.let {
                            userList.add(it)
                        }
                    }

                    _responseAllUser.postValue(userList)



                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w("TAG","Failed to read value", error.toException())
                }
            })
        }

    }

}