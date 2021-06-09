package com.adhityabagasmiwa.submissionjetpackpro.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.model.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.databinding.ActivityDetailBinding
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.DetailViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.appbar.AppBarLayout

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        activityDetailBinding.btnBack.setOnClickListener { finish() }

        val catalogueId = intent.getIntExtra(EXTRA_ID, 0)
        val catalogueType = intent.getStringExtra(EXTRA_TYPE)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            if (catalogueType == R.string.movies_type.toString()) {
                loading()
                viewModel.setSelectedMovies(catalogueId)
                populateData(viewModel.getMoviesById())
                collapsingToolbarConfig(viewModel.getMoviesById())
            } else if (catalogueType == R.string.tv_type.toString()) {
                loading()
                viewModel.setSelectedTvShow(catalogueId)
                populateData(viewModel.getTvShowById())
                collapsingToolbarConfig(viewModel.getTvShowById())
            }
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun populateData(catalogueEntity: CatalogueEntity) {
        activityDetailBinding.tvTitle.text = catalogueEntity.title
        activityDetailBinding.tvRuntime.text = catalogueEntity.duration
        activityDetailBinding.tvScore.text = catalogueEntity.score.toString()
        activityDetailBinding.tvVoteCount.text = catalogueEntity.vote_count.toString()
        activityDetailBinding.tvReleaseDate.text = catalogueEntity.release_date
        activityDetailBinding.tvGenres.text = catalogueEntity.genres
        activityDetailBinding.tvDescription.text = catalogueEntity.overview

        Glide.with(this)
            .load(catalogueEntity.poster)
            .centerCrop()
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_placeholder_image)
                    .error(R.drawable.ic_broken_image)
            )
            .into(activityDetailBinding.ivSmallPoster)

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500" + catalogueEntity.big_poster)
            .centerCrop()
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_placeholder_image)
                    .error(R.drawable.ic_broken_image)
            )
            .into(activityDetailBinding.ivBigPoster)

        activityDetailBinding.btnTrailer.setOnClickListener {
            val trailerKey = catalogueEntity.trailer_key
            val mIntent = Intent(Intent.ACTION_VIEW)
            mIntent.data = (Uri.parse("https://www.youtube.com/watch?v=$trailerKey"))
            val mChooser = Intent.createChooser(mIntent, "Open with")
            if (mIntent.resolveActivity(packageManager) != null) {
                startActivity(mChooser)
            }
        }
    }

    private fun collapsingToolbarConfig(catalogueEntity: CatalogueEntity) {
        val appBarLayout = activityDetailBinding.appBar
        val collapsingToolbarLayout = activityDetailBinding.collapsingToolbar
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = true
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) if (appBarLayout != null) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = catalogueEntity.title.toString()
                    collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = " "
                    isShow = false
                }
            }
        })
    }

    private fun loading() {
        activityDetailBinding.progressBar.visibility = View.GONE
        activityDetailBinding.coordinatorLayout.visibility = View.VISIBLE
    }
}