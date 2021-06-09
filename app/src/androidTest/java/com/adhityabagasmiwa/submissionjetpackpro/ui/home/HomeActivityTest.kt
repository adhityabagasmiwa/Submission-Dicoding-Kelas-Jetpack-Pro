package com.adhityabagasmiwa.submissionjetpackpro.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(withText(dummyMovies[0].duration)))
        onView(withId(R.id.tv_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_score)).check(matches(withText("${dummyMovies[0].score}")))
        onView(withId(R.id.tv_vote_count)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_count)).check(matches(withText("${dummyMovies[0].vote_count}")))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyMovies[0].release_date)))
        onView(withId(R.id.tv_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genres)).check(matches(withText(dummyMovies[0].genres)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyMovies[0].overview)))
    }

    @Test
    fun loadTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tv_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_runtime)).check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.tv_score)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_score)).check(matches(withText("${dummyTvShow[0].score}")))
        onView(withId(R.id.tv_vote_count)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_vote_count)).check(matches(withText("${dummyTvShow[0].vote_count}")))
        onView(withId(R.id.tv_release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).check(matches(withText(dummyTvShow[0].release_date)))
        onView(withId(R.id.tv_genres)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genres)).check(matches(withText(dummyTvShow[0].genres)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyTvShow[0].overview)))
    }

    @Test
    fun detailBackButtonMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_back)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun detailBackButtonTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_back)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
    }

    @Test
    fun playingTrailerMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_trailer)).perform(click())
    }

    @Test
    fun playingTrailerTvShow() {
        onView(withText("Tv Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_trailer)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_trailer)).perform(click())
    }
}