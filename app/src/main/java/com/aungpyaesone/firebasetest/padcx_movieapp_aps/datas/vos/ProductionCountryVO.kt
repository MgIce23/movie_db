package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class ProductionCountryVO(
    @SerializedName("iso_3166_1")var iso_3166_1: String,
    @SerializedName("name")var name: String

)