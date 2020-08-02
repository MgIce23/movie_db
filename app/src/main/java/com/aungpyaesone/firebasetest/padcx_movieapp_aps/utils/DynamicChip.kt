package com.aungpyaesone.firebasetest.padcx_movieapp_aps.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.core.view.get
import androidx.core.view.size
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup

fun createDynamicChip(chipList: List<GenersVO>,chipGroup: ChipGroup){
    var chip  = Chip(chipGroup.context)
    for(item in 0 until chipList.size){
        chip.text = chipList[item].name
    }
    chipGroup.addView(chip)

}