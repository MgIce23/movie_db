package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.ProductionCompanyVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.ProductionCountryVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCountryConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<ProductionCountryVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<ProductionCountryVO> {
        val commentListType = object : TypeToken<ArrayList<ProductionCountryVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}