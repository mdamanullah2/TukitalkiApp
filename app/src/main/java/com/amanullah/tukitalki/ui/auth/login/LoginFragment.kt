package com.amanullah.tukitalki.ui.auth.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.amanullah.tukitalki.R
import com.amanullah.tukitalki.base.BaseFragment
import com.amanullah.tukitalki.data.login.RequestUserLogin
import com.amanullah.tukitalki.databinding.FragmentLoginBinding
import com.amanullah.tukitalki.utils.ErrorMessage
import com.amanullah.tukitalki.utils.SuccessMessage
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel:LoginViewModel by viewModels()


    //To retain user login
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val user= FirebaseAuth.getInstance().currentUser
        user?.let {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment3)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.responseLogin.observe(viewLifecycleOwner){
            when(it){
                SuccessMessage ->{
                    Toast.makeText(requireContext(), SuccessMessage, Toast.LENGTH_LONG).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homeFragment3)

                }
                ErrorMessage ->{
                    Toast.makeText(requireContext(), ErrorMessage, Toast.LENGTH_LONG).show()

                }
                else->{
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()

                }
            }


        }

        binding.loginButton.setOnClickListener {
            val email= binding.editEditText.text.toString().trim()
            val password= binding.passwordEditText.text.toString().trim()

            login(email, password)

        }

        binding.registerTextView.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }


    }

    private fun login(email: String, password: String) {

        val request= RequestUserLogin(email=email, password=password)

        viewModel.login(request)

    }


}