package com.aungpyaesone.firebasetest.padcx_movieapp_aps.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class WesternFragment : BaseFragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_western,container,false)
        return v
    }

    companion object{
        fun newInstance(param1: String, param2: String) =
            WesternFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}