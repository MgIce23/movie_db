package com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.GenerListConveter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.ProductionCompanyConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.ProductionCountryConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence.SpokenLanguageConverter

import com.google.gson.annotations.SerializedName

@Entity(tableName = "MovieDetail")
@TypeConverters(GenerListConveter::class,ProductionCompanyConverter::class,
ProductionCountryConverter::class,SpokenLanguageConverter::class)
data class MovieVO(
    @SerializedName("adult") var adult: Boolean,
    @SerializedName("backdrop_path") var backdrop_path: String? = null,
    @SerializedName("budget") var budget: Int,

    @SerializedName("genres") var genres: ArrayList<GenersVO> = arrayListOf(),
    @SerializedName("homepage") var homepage: String? = null,
    @PrimaryKey
    @SerializedName("id") var id: Int,
    @SerializedName("imdb_id") var imdb_id: String? = null,
    @SerializedName("original_language") var original_language: String,
    @SerializedName("original_title") var original_title: String,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("popularity") var popularity: Float,
    @SerializedName("poster_path") var poster_path: String? = null,
    @SerializedName("production_companies") var production_companies: ArrayList<ProductionCompanyVO> = arrayListOf(),
    @SerializedName("production_countries") var production_countries: ArrayList<ProductionCountryVO> = arrayListOf(),
    @SerializedName("release_date") var release_date: String,
    @SerializedName("revenue") var revenue: Int,
    @SerializedName("runtime") var runtime: Int? = null,
    @SerializedName("spoken_languages") var spoken_languages: ArrayList<SpokenLanguageVO> = arrayListOf(),
    @SerializedName("status") var status: String,
    @SerializedName("tagline") var tagline: String? = null,
    @SerializedName("video") var video: Boolean,
    @SerializedName("vote_average") var vote_average: Float,
    @SerializedName("vote_count") var vote_count: Int
//   @SerializedName("belongs_to_collection")var belongs_to_collection

) {
}