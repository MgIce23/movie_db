package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class CastVO(
    @SerializedName("cast_id")var cast_id: Int,
    @SerializedName("character")var character : String,
    @SerializedName("credit_id")var credit_id : String,
    @SerializedName("gender")var gender : Int,
    @SerializedName("id")var id : Int,
    @SerializedName("name")var name : String,
    @SerializedName("order") var order : Int,
    @SerializedName("profile_path") var profile_path: String
) {
}