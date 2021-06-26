package com.adhityabagasmiwa.submissionjetpackpro.ui.tvshow

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.source.local.entity.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.databinding.ItemsDataListBinding
import com.adhityabagasmiwa.submissionjetpackpro.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.adhityabagasmiwa.submissionjetpackpro.BuildConfig.IMG_URL
import com.bumptech.glide.load.engine.DiskCacheStrategy

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<CatalogueEntity>()

    fun setTvShow(tvShow: List<CatalogueEntity>?) {
        if (tvShow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsTvShowBinding = ItemsDataListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsTvShowBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShow[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int {
        Log.d("DataSize: ", listTvShow.size.toString())
        return listTvShow.size
    }

    class TvShowViewHolder(private val binding: ItemsDataListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: CatalogueEntity) {
            with(binding) {
                tvTitle.text = tvShow.title
                tvDescription.text = tvShow.overview
                tvScore.text = tvShow.voteAverage.toString()
                itemView.setOnClickListener {
                    val mIntent = Intent(itemView.context, DetailActivity::class.java)
                    mIntent.putExtra(DetailActivity.EXTRA_ID, tvShow.id.toString())
                    mIntent.putExtra(DetailActivity.EXTRA_TYPE, R.string.tv_type.toString())
                    itemView.context.startActivity(mIntent)
                }
                Glide.with(itemView.context)
                    .load(IMG_URL + tvShow.posterPath)
                    .skipMemoryCache(true)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}