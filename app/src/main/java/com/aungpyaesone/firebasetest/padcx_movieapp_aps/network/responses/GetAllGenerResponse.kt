package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.google.gson.annotations.SerializedName

data class GetAllGenerResponse(
    @SerializedName("genres")var generlist:ArrayList<GenersVO> = arrayListOf()
) {
}