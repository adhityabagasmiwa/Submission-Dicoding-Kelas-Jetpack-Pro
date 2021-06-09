package com.adhityabagasmiwa.submissionjetpackpro.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhityabagasmiwa.submissionjetpackpro.R
import com.adhityabagasmiwa.submissionjetpackpro.data.model.CatalogueEntity
import com.adhityabagasmiwa.submissionjetpackpro.databinding.ItemsDataListBinding
import com.adhityabagasmiwa.submissionjetpackpro.ui.detail.DetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<CatalogueEntity>()

    fun setMovies(movies: List<CatalogueEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding = ItemsDataListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size

    class MoviesViewHolder(private val binding: ItemsDataListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: CatalogueEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvRuntime.text = movies.duration
                tvScore.text = movies.score.toString()
                itemView.setOnClickListener {
                    val mIntent = Intent(itemView.context, DetailActivity::class.java)
                    mIntent.putExtra(DetailActivity.EXTRA_ID, movies.id)
                    mIntent.putExtra(DetailActivity.EXTRA_TYPE, R.string.movies_type.toString())
                    itemView.context.startActivity(mIntent)
                }
                Glide.with(itemView.context)
                    .load(movies.poster)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_placeholder_image)
                            .error(R.drawable.ic_broken_image)
                    )
                    .into(imgPoster)
            }
        }
    }
}