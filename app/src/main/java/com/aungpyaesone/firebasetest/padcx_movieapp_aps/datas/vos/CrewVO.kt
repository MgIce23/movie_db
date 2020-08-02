package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import com.google.gson.annotations.SerializedName

data class CrewVO(
    @SerializedName("credit_id")var credit_id : String,
    @SerializedName("job")var job : String,
    @SerializedName("id")var id : Int,
    @SerializedName("gender")var gender:Int,
    @SerializedName("name")var name : String,
    @SerializedName("department") var department : String,
    @SerializedName("profile_path") var profile_path: String

) {
}