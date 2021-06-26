package com.adhityabagasmiwa.submissionjetpackpro.ui.detail

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.adhityabagasmiwa.submissionjetpackpro.BuildConfig.IMG_URL
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.DetailEntity
import com.adhityabagasmiwa.submissionjetpackpro.databinding.ActivityDetailBinding
import com.adhityabagasmiwa.submissionjetpackpro.utils.formatDate
import com.adhityabagasmiwa.submissionjetpackpro.utils.glideConfig
import com.adhityabagasmiwa.submissionjetpackpro.utils.timeConvertMovies
import com.adhityabagasmiwa.submissionjetpackpro.utils.timeConvertTvShow
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.DetailViewModel
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout

class DetailActivity : AppCompatActivity() {

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)

        activityDetailBinding.btnBack.setOnClickListener { finish() }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
        window.statusBarColor = Color.TRANSPARENT

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]
        val extras = intent.extras

        if (extras != null) {
            showShimmer()
            val catalogueId = extras.getString(EXTRA_ID)
            val catalogueType = extras.getString(EXTRA_TYPE)

            if (catalogueId != null && catalogueType != null) {
                viewModel.setCatalogue(catalogueId, catalogueType)
                viewModel.getCatalogueDetail().observe(this, { detailCatalogue ->
                    hideShimmer()
                    populateData(detailCatalogue)
                    collapsingToolbarConfig(detailCatalogue)
                })
            }
        }
    }

    private fun populateData(detailEntity: DetailEntity) {
        val typeMovies = "movie"
        val typeTvShow = "tv"
        val extras = intent.extras
        val catalogueType = extras!!.getString(EXTRA_TYPE)

        if (catalogueType == R.string.movies_type.toString()) {
            activityDetailBinding.tvRuntime.text = detailEntity.runtime?.let { timeConvertMovies(it) }
            activityDetailBinding.btnShare.setOnClickListener {
                shareCatalogue(detailEntity.id.toString(), typeMovies)
            }
        } else {
            activityDetailBinding.tvRuntime.text = detailEntity.runtime?.let { timeConvertTvShow(it) }
            activityDetailBinding.btnShare.setOnClickListener {
                shareCatalogue(detailEntity.id.toString(), typeTvShow)
            }
        }
        if (detailEntity.releaseDate == "") {
            activityDetailBinding.tvReleaseDate.text = ""
        } else {
            activityDetailBinding.tvReleaseDate.text = detailEntity.releaseDate?.let { formatDate(it) }
        }

        activityDetailBinding.tvTitle.text = detailEntity.title
        activityDetailBinding.tvScore.text = detailEntity.voteAverage.toString()
        activityDetailBinding.tvVoteCount.text = detailEntity.voteCount.toString()
        activityDetailBinding.tvGenres.text = detailEntity.genres.toString().replace("[", "").replace("]", "")
        activityDetailBinding.tvDescription.text = detailEntity.overview
        glideConfig(this, IMG_URL + detailEntity.posterPath, activityDetailBinding.ivSmallPoster)
        glideConfig(this, IMG_URL + detailEntity.backdropPath, activityDetailBinding.ivBigPoster)

        /*activityDetailBinding.btnTrailer.setOnClickListener {
            val trailerKey = catalogueEntity.trailer_key
            val mIntent = Intent(Intent.ACTION_VIEW)
            mIntent.data = (Uri.parse("https://www.youtube.com/watch?v=$trailerKey"))
            val mChooser = Intent.createChooser(mIntent, "Open with")
            if (mIntent.resolveActivity(packageManager) != null) {
                startActivity(mChooser)
            }
        }*/
    }

    private fun collapsingToolbarConfig(detailEntity: DetailEntity) {
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
                    collapsingToolbarLayout.title = detailEntity.title.toString()
                    collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarTextAppearance)
                    activityDetailBinding.btnBack.setImageResource(R.drawable.ic_arrow_back)
                    activityDetailBinding.btnBack.setBackgroundColor(Color.TRANSPARENT)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = " "
                    isShow = false
                    activityDetailBinding.btnBack.setImageResource(R.drawable.ic_arrow_small_back)
                    activityDetailBinding.btnBack.setBackgroundResource(R.drawable.bg_rounded_transparent)
                }
            }
        })
    }

    private fun shareCatalogue(id: String, type: String) {
        val mUrl = "https://www.themoviedb.org/"
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "$mUrl${type}/$id")
        startActivity(Intent.createChooser(shareIntent, "Share via"))
        Log.d("ShareIntent", shareIntent.toString())
    }

    private fun setWindowFlag(mBits: Int, mOn: Boolean) {
        val win = window
        val winParams = win.attributes
        if (mOn) {
            winParams.flags = winParams.flags or mBits
        } else {
            winParams.flags = winParams.flags and mBits.inv()
        }
        win.attributes = winParams
    }

    private fun showShimmer() {
        activityDetailBinding.shimmerLayout.startShimmer()
        activityDetailBinding.shimmerLayout.visibility = View.VISIBLE
        activityDetailBinding.progressBarDetailCatalogue.visibility = View.VISIBLE
    }

    private fun hideShimmer() {
        activityDetailBinding.shimmerLayout.stopShimmer()
        activityDetailBinding.shimmerLayout.visibility = View.GONE
        activityDetailBinding.progressBarDetailCatalogue.visibility = View.GONE
        activityDetailBinding.coordinatorLayout.visibility = View.VISIBLE
    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}