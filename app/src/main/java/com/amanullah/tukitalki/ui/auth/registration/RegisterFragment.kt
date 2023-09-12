package com.amanullah.tukitalki.ui.auth.registration

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.amanullah.tukitalki.base.BaseFragment
import com.amanullah.tukitalki.data.register.RequestUserRegister
import com.amanullah.tukitalki.databinding.FragmentRegisterBinding
import com.amanullah.tukitalki.utils.DummyImgLink
import com.amanullah.tukitalki.utils.ErrorMessage
import com.amanullah.tukitalki.utils.SuccessMessage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.responseRegistration.observe(viewLifecycleOwner){
            when(it){
                SuccessMessage->{
                    Toast.makeText(requireContext(), SuccessMessage, Toast.LENGTH_LONG).show()
                }
                ErrorMessage->{
                    Toast.makeText(requireContext(), ErrorMessage, Toast.LENGTH_LONG).show()

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

                val request = RequestUserRegister(
                    name=name,
                    email = email,
                    password = password,
                    createdAt = System.currentTimeMillis(),
                    image = DummyImgLink   //App branding logo more usable.
                    )
                viewModel.registration(request)

            }

        }

        binding.loginTextView.setOnClickListener {

            findNavController().popBackStack()
        }

        super.onViewCreated(view, savedInstanceState)
    }

}