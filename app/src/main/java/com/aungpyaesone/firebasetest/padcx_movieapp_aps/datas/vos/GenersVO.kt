package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Gener")
data class GenersVO(
    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("name")var name: String
) {
}