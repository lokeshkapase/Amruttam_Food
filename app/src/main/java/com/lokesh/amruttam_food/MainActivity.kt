package com.lokesh.amruttam_food

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerDeals: ViewPager2
    private lateinit var recyclerViewAllItems: RecyclerView

    private val imageList = listOf(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3
    )

    private val itemList = listOf(
        Product("Dink Ladoo", "250 Grams", "₹150", R.drawable.dink_ladoo),
        Product("Til Ladoo", "250 Grams", "₹200", R.drawable.til_ladoo)
    )

    private val sliderHandler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        // Deals Section
        viewPagerDeals = findViewById(R.id.viewPagerDeals)
        viewPagerDeals.adapter = DealsAdapter(imageList)
        viewPagerDeals.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                sliderHandler.removeCallbacks(sliderRunnable)
                sliderHandler.postDelayed(sliderRunnable, 3000)
            }
        })

        // All Items Section
        recyclerViewAllItems = findViewById(R.id.recyclerView)
        recyclerViewAllItems.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewAllItems.adapter = ItemsAdapter(itemList)
    }

    private val sliderRunnable = Runnable {
        val nextPos = (viewPagerDeals.currentItem + 1) % imageList.size
        viewPagerDeals.setCurrentItem(nextPos, true)
    }

    override fun onPause() {
        super.onPause()
        sliderHandler.removeCallbacks(sliderRunnable)
    }

    override fun onResume() {
        super.onResume()
        sliderHandler.postDelayed(sliderRunnable, 3000)
    }
}
