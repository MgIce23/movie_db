package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.CastTypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.CrewTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "castAndCrew")
@TypeConverters(CastTypeConverter::class,CrewTypeConverter::class)
data class CastAndCrewVO(
    @PrimaryKey
    @SerializedName("id")var id: Int,
    @SerializedName("crew")var crew:ArrayList<CrewVO> = arrayListOf(),
    @SerializedName("cast")var cast: ArrayList<CastVO> = arrayListOf()
) {
}