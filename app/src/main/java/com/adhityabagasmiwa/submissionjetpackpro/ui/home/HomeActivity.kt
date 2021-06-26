package com.adhityabagasmiwa.submissionjetpackpro.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.databinding.ActivityHomeBinding
import com.adhityabagasmiwa.submissionjetpackpro.ui.movies.MoviesFragment
import com.adhityabagasmiwa.submissionjetpackpro.ui.tvshow.TvShowFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var activityHomeBinding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        activityHomeBinding.toolbar.title = getString(R.string.app_name)

        loadFragment(MoviesFragment())

        activityHomeBinding.bottomNavigation.setItemSelected(R.id.movies)
        activityHomeBinding.bottomNavigation.setOnItemSelectedListener {
            when (it) {
                R.id.movies -> loadFragment(MoviesFragment())
                R.id.tv_show -> loadFragment(TvShowFragment())
            }
        }
        supportActionBar?.elevation = 0f
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fm_container, fragment)
                .commit()
            return true
        }
        return false
    }
}