package com.adhityabagasmiwa.submissionjetpackpro.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.utils.DataDummy
import com.adhityabagasmiwa.submissionjetpackpro.utils.EspressoIdlingResource
import com.adhityabagasmiwa.submissionjetpackpro.utils.timeConvertMovies
import com.adhityabagasmiwa.submissionjetpackpro.utils.timeConvertTvShow
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private var movies = DataDummy.getMovies()
    private var tvShows = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource())
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource())
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            onView(allOf(withId(R.id.iv_big_poster), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.iv_small_poster), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_title), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_title), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(movies[0].title)))
            onView(allOf(withId(R.id.tv_runtime), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_runtime), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(movies[0].runtime?.let { withText(timeConvertMovies(it)) }))
            onView(allOf(withId(R.id.tv_score), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_score), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(movies[0].voteAverage.toString())))
            onView(allOf(withId(R.id.tv_vote_count), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_vote_count), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(movies[0].voteCount?.let { withText(it.toString()) }))
            onView(allOf(withId(R.id.tv_release_date), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_release_date), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(movies[0].releaseDate)))
            onView(allOf(withId(R.id.tv_genres), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_genres), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(movies[0].genres.toString().replace("[", "").replace("]", ""))))
            onView(allOf(withId(R.id.tv_description), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_description), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(movies[0].overview)))
        }
    }

    @Test
    fun loadTvShow() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadTvShowDetail() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).apply {
            check(matches(isDisplayed()))
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            onView(allOf(withId(R.id.iv_big_poster), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.iv_small_poster), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_title), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_title), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(tvShows[0].title)))
            onView(allOf(withId(R.id.tv_runtime), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_runtime), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(tvShows[0].runtime?.let { withText(timeConvertTvShow(it)) }))
            onView(allOf(withId(R.id.tv_score), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_score), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(tvShows[0].voteAverage.toString())))
            onView(allOf(withId(R.id.tv_vote_count), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_vote_count), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(tvShows[0].voteCount?.let { withText(it.toString()) }))
            onView(allOf(withId(R.id.tv_release_date), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_release_date), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(tvShows[0].releaseDate)))
            onView(allOf(withId(R.id.tv_genres), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_genres), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(tvShows[0].genres.toString().replace("[", "").replace("]", ""))))
            onView(allOf(withId(R.id.tv_description), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
            onView(allOf(withId(R.id.tv_description), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(withText(tvShows[0].overview)))
        }
    }

    @Test
    fun detailBackButtonMovies() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            onView(withId(R.id.btn_back)).perform(click())
            check(matches(isDisplayed()))
        }
    }

    @Test
    fun detailBackButtonTvShow() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).apply {
            perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
            onView(withId(R.id.btn_back)).perform(click())
        }
    }

    @Test
    fun shareMovies() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(allOf(withId(R.id.btn_share), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.btn_share), withEffectiveVisibility(Visibility.VISIBLE))).perform(click())
    }

    @Test
    fun shareTvShow() {
        onView(withId(R.id.bottom_navigation)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_show)).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(allOf(withId(R.id.btn_share), withEffectiveVisibility(Visibility.VISIBLE))).check(matches(isDisplayed()))
        onView(allOf(withId(R.id.btn_share), withEffectiveVisibility(Visibility.VISIBLE))).perform(click())
    }
}