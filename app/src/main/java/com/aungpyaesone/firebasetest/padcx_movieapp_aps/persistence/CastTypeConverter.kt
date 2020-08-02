package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CastVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CastTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<CastVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<CastVO> {
        val commentListType = object : TypeToken<ArrayList<CastVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}