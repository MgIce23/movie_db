package com.aungpyaesone.firebasetest.padcx_movieapp_aps.persistence

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenerTypeConverter {
    @TypeConverter
    fun toString(commentList: ArrayList<Int>): String {
        return Gson().toJson(commentList)
    }

    @TypeConverter
    fun toCommentList(commentListJsonStr: String): ArrayList<Int> {
        val commentListType = object : TypeToken<ArrayList<Int>>() {}.type
        return Gson().fromJson(commentListJsonStr, commentListType)
    }
}