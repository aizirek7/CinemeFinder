package com.example.cinemafinder.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.cinemafinder.R
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Utils
import com.example.cinemafinder.databinding.FragmentDetailsBinding
import com.example.cinemafinder.databinding.FragmentMainBinding


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        val movie = bundle?.getSerializable(Utils.KEY) as Movie
        binding.apply {
            originalTitle.text = movie.original_title
            originalLanguage.text = movie.original_language
            releaseDate.text = movie.release_date
            overview.text = movie.overview
            context?.let {
                Glide.with(it).load(Utils.URL_IMAGE + movie.poster_path).into(imageView2)
            }
        }
    }
}