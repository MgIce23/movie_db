package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class ProductionCompanyVO (
    @SerializedName("name")var name: String,
    @SerializedName("id")var id: Int,
    @SerializedName("logo_path")var logo_path : String? = null,
    @SerializedName("origin_country")var origin_country: String
) {
}