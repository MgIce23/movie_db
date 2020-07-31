package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenerListConveter {
    @TypeConverter
    fun toString(commentList: ArrayList<GenersVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<GenersVO> {
        val commentListType = object : TypeToken<ArrayList<GenersVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}