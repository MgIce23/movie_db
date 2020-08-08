package com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModelProviders
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.VideoViewPresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.VideoViewPresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.VideoView
import com.example.shared.activities.BaseActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.video_view_layout.*


class VideoViewActivity : BaseActivity(),VideoView{

    private var mPresenter : VideoViewPresenter? = null

    companion object{
        const val KEY = "key"
        var videoId : Int = 0
        fun newIntent(context: Context, id:Int): Intent {
            val i = Intent(context,VideoViewActivity::class.java)
            i.putExtra(KEY,id)
            return i
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_view_layout)
        setUpPresenter()
        setUp()
        mPresenter?.onUiReady(videoId,this)
    }
    fun setUp(){
        videoId = intent.getIntExtra(KEY,0)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(VideoViewPresenterImpl::class.java)
        mPresenter?.initPresenter(this)
    }

    override fun showVideo(videoKey: String) {
        lifecycle.addObserver(youtube_player_view)

        youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(@NonNull youTubePlayer: YouTubePlayer) {
                val videoId = videoKey
                youTubePlayer.loadVideo(videoId, 0f)
               // youtube_player_view.enterFullScreen()
            }
        })
    }

    override fun showErrorMessage(error: String) {
        showSnackBar(error)
    }
}