package com.adhityabagasmiwa.submissionjetpackpro.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhityabagasmiwa.submissionjetpackpro.databinding.FragmentTvShowBinding
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.TvShowViewModel
import com.adhityabagasmiwa.submissionjetpackpro.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            showProgressBar(true)
            showShimmer()
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            val tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShow ->
                showProgressBar(false)
                hideShimmer()
                tvShowAdapter.setTvShow(tvShow)
                tvShowAdapter.notifyDataSetChanged()
            })

            _binding?.let {
                with(it.rvTvShow) {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    adapter = tvShowAdapter
                }
            }
        }
    }

    private fun showProgressBar(state: Boolean) {
        _binding?.progressBarTvShow?.isVisible = state
        _binding?.rvTvShow?.isInvisible = state
    }

    private fun showShimmer() {
        _binding?.shimmerLayout?.startShimmer()
        _binding?.shimmerLayout?.visibility ?: View.VISIBLE
        _binding?.rvTvShow?.visibility ?: View.GONE
    }

    private fun hideShimmer() {
        _binding?.shimmerLayout?.stopShimmer()
        _binding?.shimmerLayout?.visibility ?: View.GONE
        _binding?.rvTvShow?.visibility ?: View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}