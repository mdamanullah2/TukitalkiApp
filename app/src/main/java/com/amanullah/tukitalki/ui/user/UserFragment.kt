package com.amanullah.tukitalki.ui.user

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.amanullah.tukitalki.base.BaseFragment
import com.amanullah.tukitalki.databinding.FragmentUserBinding
import com.amanullah.tukitalki.ui.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserFragment : BaseFragment<FragmentUserBinding>(FragmentUserBinding::inflate) {


    private val  viewModel: ProfileViewModel by viewModels()
    private lateinit var adapter: UserAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter=UserAdapter()

        viewModel.getAllUser()
        viewModel.responseAllUserProfile.observe(viewLifecycleOwner){
            adapter.submitList(it)
            binding.userRcv.adapter =adapter


        }

    }

}