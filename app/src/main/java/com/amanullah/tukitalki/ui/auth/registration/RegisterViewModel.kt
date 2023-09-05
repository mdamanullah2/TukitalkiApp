package com.amanullah.tukitalki.ui.auth.registration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amanullah.tukitalki.data.RequestUserRegister
import com.amanullah.tukitalki.repositories.AuthRepo
import com.amanullah.tukitalki.utils.registrationErrorMessage
import com.amanullah.tukitalki.utils.registrationSuccessMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: AuthRepo):ViewModel(){

    private var _response=MutableLiveData<String>()
    val responseRegistration :LiveData<String> = _response

    //Comment on function
    fun registration(
        requestUserRegister: RequestUserRegister
    ){
        viewModelScope.launch {
            repo.registration(requestUserRegister).addOnCompleteListener {

                if (it.isSuccessful){
                    _response.postValue(registrationSuccessMessage)
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