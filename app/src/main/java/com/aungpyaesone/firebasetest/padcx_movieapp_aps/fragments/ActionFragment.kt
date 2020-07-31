package com.aungpyaesone.firebasetest.padcx_movieapp_aps.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities.MovieDetailActivity
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.adapter.TopRatedMovieAdapter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.models.TopRatedMovieImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.datas.vos.TopRatedVO
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.TopRatedMoviePresenter
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.presenters.presenterImpls.TopRatedMoviePresenterImpl
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.mvp.views.TopRatedMovieView
import kotlinx.android.synthetic.main.actor_view_pod.*
import kotlinx.android.synthetic.main.fragment_action.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ActionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ActionFragment : BaseFragment(), TopRatedMovieView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mPresenter: TopRatedMoviePresenter
    private lateinit var mAdapter : TopRatedMovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_action, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(TopRatedMoviePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler(){
        mAdapter = TopRatedMovieAdapter(mPresenter)
        rvTopRatedMovie.layoutManager = LinearLayoutManager(activity,
            LinearLayoutManager.HORIZONTAL,false)
        rvTopRatedMovie.adapter = mAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ActionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showTopRatedMovieList(topMovieList: List<TopRatedVO>) {
        mAdapter.setData(topMovieList.toMutableList())
    }

    override fun navigateToDetailScreen(id: Int) {
        startActivity(activity?.let { MovieDetailActivity.newIntent(it,id) })
    }

    override fun showErrorMessage(error: String) {

    }
}