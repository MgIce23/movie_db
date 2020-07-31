package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

data class GetPopularMovieListResponse(
    @SerializedName("page")val page: Int,
    @SerializedName("total_results")var total_result : Int,
    @SerializedName("total_pages")var total_page: Int,
    @SerializedName("results")var result: ArrayList<PopularMovieVO> = arrayListOf()
)
{
    fun isresponseOk(): Boolean{
        return result.isEmpty()
    }

}