package com.faruk.miwok

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.faruk.miwok.view.adapter.CategoryAdapter
import com.faruk.miwok.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.faruk.miwok.model.data.MiwokDatabase
import com.faruk.miwok.view.components.MediaPlayerManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MiwokDatabase.getDatabase(applicationContext)

        val adapter = CategoryAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Numbers"
                1 -> "Family"
                2 -> "Colors"
                3 -> "Phrases"
                else -> ""
            }
        }.attach()
    }

    override fun onStop() {
        super.onStop()
        MediaPlayerManager.release()
    }
}
