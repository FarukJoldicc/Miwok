package com.faruk.miwok

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.faruk.miwok.databinding.ActivityMainBinding
import com.faruk.miwok.model.data.MiwokDatabase
import com.faruk.miwok.view.adapter.CategoryAdapter
import com.faruk.miwok.view.components.MediaPlayerManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

        disableTabTooltips(binding.tabLayout)
    }

    private fun disableTabTooltips(tabLayout: TabLayout) {
        val tabStrip = tabLayout.getChildAt(0) as? ViewGroup ?: return
        for (i in 0 until tabStrip.childCount) {
            val tabView = tabStrip.getChildAt(i)
            tabView.tooltipText = null
            tabView.setOnLongClickListener { true } 
        }
    }

    override fun onStop() {
        super.onStop()
        MediaPlayerManager.release()
    }
}
