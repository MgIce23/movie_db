package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.CrewVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.GenersVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CrewTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<CrewVO>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<CrewVO> {
        val commentListType = object : TypeToken<ArrayList<CrewVO>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}