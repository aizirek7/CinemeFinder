package com.example.cinemafinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.databinding.FragmentMainBinding
import com.example.cinemafinder.model.Movie
import com.example.cinemafinder.ui.main.adapter.Adapter
import com.example.cinemafinder.ui.main.adapter.OnItemClickListener

class MainFragment : Fragment(), OnItemClickListener {
    lateinit var adapter: Adapter
    var viewModel = MainViewModel()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getMovie()
        viewModel.getMovieRate()

        viewModel.liveDataWithRate().observe(viewLifecycleOwner, {
            start(it, false, binding.nowPlaying)
        })

        viewModel.liveDataWithoutRate().observe(viewLifecycleOwner, {
            start(it, true, binding.upcoming)
        })

    }

    private fun start(movies: List<Movie>, boolean: Boolean, recyclerView: RecyclerView) {
        recyclerView.layoutManager =
            LinearLayoutManager(parentFragment?.context, LinearLayoutManager.HORIZONTAL, true)
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(parentFragment?.context, boolean, movies, this)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }

}