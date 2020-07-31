package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.ProductionCompanyVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductionCompanyConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<ProductionCompanyVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<ProductionCompanyVO> {
        val commentListType = object : TypeToken<ArrayList<ProductionCompanyVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}