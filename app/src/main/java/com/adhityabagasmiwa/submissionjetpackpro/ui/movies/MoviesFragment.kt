package com.adhityabagasmiwa.submissionjetpackpro.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhityabagasmiwa.submissionjetpackpro.databinding.FragmentMoviesBinding
import com.adhityabagasmiwa.submissionjetpackpro.databinding.FragmentTvShowBinding
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.MoviesViewModel
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {

    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)
            showShimmer()
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val moviesAdapter = MoviesAdapter()

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                showProgressBar(false)
                hideShimmer()
                moviesAdapter.setMovies(movies)
                moviesAdapter.notifyDataSetChanged()
            })

            _binding?.let {
                with(it.rvMovies) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = moviesAdapter
                }
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        _binding?.progressBarMovies?.isVisible  = state
        _binding?.rvMovies?.isInvisible = state
    }

    private fun showShimmer() {
        _binding?.shimmerLayout?.startShimmer()
        _binding?.shimmerLayout?.visibility ?: View.VISIBLE
        _binding?.rvMovies?.visibility ?: View.GONE
    }

    private fun hideShimmer() {
        _binding?.shimmerLayout?.stopShimmer()
        _binding?.shimmerLayout?.visibility ?: View.GONE
        _binding?.rvMovies?.visibility ?: View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}