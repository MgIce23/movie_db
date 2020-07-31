package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class SpokenLanguageVO(
    @SerializedName("iso_639_1")var iso_639_1: String,
    @SerializedName("name")var name : String
)