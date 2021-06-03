package com.example.cinemafinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cinemafinder.databinding.ActivityMainBinding
import com.example.cinemafinder.ui.main.FavouriteFragment
import com.example.cinemafinder.ui.main.MainFragment
import com.example.cinemafinder.ui.main.RateFragment

class MainActivity : AppCompatActivity(){

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(MainFragment())

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_menu -> setFragment(MainFragment())
                R.id.favourite_menu -> setFragment(FavouriteFragment())
                R.id.ratings_menu -> setFragment(RateFragment())

            }
            true
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }






}