package com.aungpyaesone.firebasetest.padcx_movieapp_aps.network.responses

import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.NowPlayingVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

class GetNowPlayingMovieListRespone (
    @SerializedName("page")val page: Int,
    @SerializedName("total_results")var total_result : Int,
    @SerializedName("total_pages")var total_page: Int,
    @SerializedName("results")var result: ArrayList<NowPlayingVO> = arrayListOf()
) {
}