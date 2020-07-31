package com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.fragments.*

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){
    val itemList  = arrayListOf("Action","Adventure","Criminal","Drama","Comdey","Animation","Family","Fantasty",
    "History","Horror","Music","Mystery","Romance","Science","Tv movie","Thriller","War","Western")
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ActionFragment.newInstance("","")
            1 -> return AdventureFragment.newInstance("","")
            3 -> return CriminalFragment.newInstance("","")
            4 -> return DramaFragment.newInstance("","")
            5 -> return ComdeyFragment.newInstance("","")
            6 -> return AnimationFragment.newInstance("","")
            7 -> return FamilyFragment.newInstance("","")
            8 -> return FantastyFragment.newInstance("","")
            9 -> return HistoryFragment.newInstance("","")
            10 -> return HorrorFragment.newInstance("","")
            11 -> return MusicFragment.newInstance("","")
            12 -> return MysteryFragment.newInstance("","")
            13 -> return RomaceFragment.newInstance("","")
            14 -> return ScienceFragment.newInstance("","")
            15 -> return TVMovieFragment.newInstance("","")
            16 -> return ThrillerFragment.newInstance("","")
            17 -> return WarFragment.newInstance("","")
            18 -> return WesternFragment.newInstance("","")

            else -> return ActionFragment.newInstance("","")

        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return itemList[position]
    }

    override fun getCount(): Int {
        return itemList.size
    }

}