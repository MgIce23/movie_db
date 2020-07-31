package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.GenerTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "topMovie")
@TypeConverters(GenerTypeConverter::class)
data class TopRatedVO(
    @SerializedName("popularity") var popularity: Float,
    @SerializedName("poster_path") var poster_path: String? = null,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("release_date") var release_date: String,
    @SerializedName("genre_ids")var genre_ids: ArrayList<Int> = arrayListOf(),
    @PrimaryKey
    @SerializedName("id") var id: Int,
    @SerializedName("original_language") var original_language: String,
    @SerializedName("original_title") var original_title: String,
    @SerializedName("title")var title: String? = null,
    @SerializedName("backdrop_path") var backdrop_path: String? = null,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Float,
    @SerializedName("vote_count") var vote_count: Int
) {
}