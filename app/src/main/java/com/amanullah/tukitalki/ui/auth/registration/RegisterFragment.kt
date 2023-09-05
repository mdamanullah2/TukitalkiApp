package com.amanullah.tukitalki.ui.auth.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.amanullah.tukitalki.base.BaseFragment
import com.amanullah.tukitalki.data.RequestUserRegister
import com.amanullah.tukitalki.databinding.FragmentRegisterBinding
import com.amanullah.tukitalki.utils.registrationErrorMessage
import com.amanullah.tukitalki.utils.registrationSuccessMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.responseRegistration.observe(viewLifecycleOwner){
            when(it){
                registrationSuccessMessage->{
                    Toast.makeText(requireContext(), registrationSuccessMessage, Toast.LENGTH_LONG).show()
                }
                registrationErrorMessage->{
                    Toast.makeText(requireContext(), registrationErrorMessage, Toast.LENGTH_LONG).show()

                }
                else->{
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()

                }
            }
        }

        binding.registerButton.setOnClickListener {

            binding.apply {

              val name = usernameEdittext.text.toString()
              val email = emailEdittext.text.toString()
              val password = passwordEdittext.text.toString()
              val confirmPassword = confirmPasswordEdittext.text.toString()

                val request =RequestUserRegister(name=name, email = email, password = password)
                viewModel.registration(request)

            }

        }

        super.onViewCreated(view, savedInstanceState)
    }

}