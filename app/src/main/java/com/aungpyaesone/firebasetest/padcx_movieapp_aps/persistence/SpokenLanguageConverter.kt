package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.ProductionCompanyVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.SpokenLanguageVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SpokenLanguageConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<SpokenLanguageVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<SpokenLanguageVO> {
        val commentListType = object : TypeToken<ArrayList<SpokenLanguageVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}