package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.MovieResultVO
import com.google.gson.annotations.SerializedName

data class GetVideoResponse(
    @SerializedName("id") var id :Int,
    @SerializedName("results") var result : ArrayList<MovieResultVO> = arrayListOf()
)
