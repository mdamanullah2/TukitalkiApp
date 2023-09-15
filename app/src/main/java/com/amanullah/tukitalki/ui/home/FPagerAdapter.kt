package com.amanullah.tukitalki.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.amanullah.tukitalki.ui.chat.ChatFragment
import com.amanullah.tukitalki.ui.profile.ProfileFragment
import com.amanullah.tukitalki.ui.user.UserFragment

class FPagerAdapter ( fm : FragmentManager) : FragmentPagerAdapter(fm) {

    var names= arrayOf("User","Chat", "Profile")
    override fun getCount(): Int {
        return names.size
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> UserFragment()
           1 -> ChatFragment()
           else ->  ProfileFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {



        return names[position]
    }

}