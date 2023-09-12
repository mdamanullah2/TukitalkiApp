package com.amanullah.tukitalki.ui.auth.registration

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.repositories.AuthRepo
import com.amanullah.tukitalki.repositories.UserRepo
import com.amanullah.tukitalki.utils.ErrorMessage
import com.amanullah.tukitalki.utils.SuccessMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(private val repo: AuthRepo, private val userRepo: UserRepo):ViewModel(){

    private var _response=MutableLiveData<String>()
    val responseRegistration :LiveData<String> = _response

    //Comment on function
    fun registration(
        requestUserRegister: RequestUserRegister
    ){
        viewModelScope.launch {
            repo.registration(requestUserRegister).addOnCompleteListener {

                if (it.isSuccessful){
                    requestUserRegister.userId= it.result.user!!.uid

                    viewModelScope.launch {
                        userRepo.createUser(requestUserRegister).addOnCompleteListener { dbIt ->
                            if (it.isSuccessful) {
                                _response.postValue(SuccessMessage)
                            } else {
                                _response.postValue(ErrorMessage)
                                _response.postValue(it.exception?.message ?: ErrorMessage)
                            }
                        }

                    }



                  //
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