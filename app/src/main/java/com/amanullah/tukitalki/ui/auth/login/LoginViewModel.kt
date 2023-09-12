package com.amanullah.tukitalki.ui.auth.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.repositories.AuthRepo
import com.amanullah.tukitalki.utils.SuccessMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo):ViewModel(){

    private var _response=MutableLiveData<String>()
    val responseLogin :LiveData<String> = _response

    //Comment on function
    fun login(
        request: RequestUserLogin
    ){
        viewModelScope.launch {
            repo.login(request).addOnCompleteListener {

                if (it.isSuccessful){
                    _response.postValue(SuccessMessage)
                }
//                else{
//                    _response.postValue(registrationErrorMessage)
//                    //_response.postValue(it.exception?.message ?: registrationErrorMessage)
//
//                }
            }.addOnFailureListener {
                Log.d("TAG,", "${it.localizedMessage}:")
            }
        }
    }

}