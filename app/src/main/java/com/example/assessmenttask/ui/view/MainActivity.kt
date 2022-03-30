package com.example.assessmenttask.ui.view

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.viewpager2.widget.ViewPager2
import com.example.assessmenttask.R
import com.example.assessmenttask.adapter.PagerAdapter
import com.example.assessmenttask.database.AppDatabase
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tabLayout = findViewById(R.id.tablayout)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){
                tab, index -> tab.text = when(index){
            0 -> {"Posts"}
            1 -> {"Favourites"}
            else -> {
                throw Resources.NotFoundException("Position not found")
            }
        }
        }.attach()
    }

}

