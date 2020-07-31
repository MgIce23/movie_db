package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "peoples")
data class PeopleVO(
    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("name") var name: String? = null,
    @SerializedName("profile_path") var profile_path: String,
    @SerializedName("adult")var adult : Boolean,
    @SerializedName("popularity") var popularity: Float

) {
}