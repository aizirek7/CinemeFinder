package com.example.cinemafinder.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemafinder.R
import com.example.cinemafinder.data.Movie
import com.example.cinemafinder.data.Utils
import com.example.cinemafinder.databinding.FragmentMainBinding
import com.example.cinemafinder.ui.main.adapter.Adapter
import com.example.cinemafinder.ui.main.adapter.OnItemClickListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

        viewModel.liveDataMovieWithRate.observe(viewLifecycleOwner, {
            start(it, true, binding.upcoming)
        })
        viewModel.livedataMovieWithoutRate.observe(viewLifecycleOwner, {
            start(it, false, binding.nowPlaying)
        })
    }

    fun start(movies: List<Movie>, boolean: Boolean, recyclerView: RecyclerView) {
        recyclerView.layoutManager =
            LinearLayoutManager(parentFragment?.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.setHasFixedSize(true)
        adapter = Adapter(parentFragment?.context, boolean, movies.sortedByDescending { it.vote_average }, this
        )
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int, movies: List<Movie>) {
        val bundle = Bundle()
        bundle.putSerializable(Utils.KEY, movies.get(position))

        val fragment = DetailsFragment()
        fragment.arguments = bundle

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}