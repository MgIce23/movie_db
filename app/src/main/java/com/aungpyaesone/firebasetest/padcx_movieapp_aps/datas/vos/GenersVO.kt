package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class GenersVO(
    @SerializedName("id")var id: Int,
    @SerializedName("name")var name: String
) {
}