package com.aungpyaesone.firebasetest.padcx_movieapp_aps.uitest

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.R
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.activities.MovieHomeActivity
import com.aungpyaesone.firebasetest.padcx_movieapp_aps.views.viewholders.BestPopularFilmViewHolder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailTest {
    private val activityTestRule = ActivityTestRule<MovieHomeActivity>(MovieHomeActivity::class.java)

    @Before
    open fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun onTabMovieItem_GoToDetail(){
        onView(withId(R.id.rvBestFlimandSeries)).perform(
            RecyclerViewActions.actionOnItemAtPosition<BestPopularFilmViewHolder>(0,click())
        )
        onView(withId(R.id.tvYear)).check(matches(isDisplayed()))
    }




}