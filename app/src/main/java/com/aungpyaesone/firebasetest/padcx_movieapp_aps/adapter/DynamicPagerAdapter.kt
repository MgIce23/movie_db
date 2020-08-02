package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.fragments.ActionFragment

class DynamicPagerAdapter(val generList: List<GenersVO>,fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager,
BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return ActionFragment.newInstance(generList[position].id)
    }

    override fun getCount(): Int {
        return generList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return generList[position].name
    }
}