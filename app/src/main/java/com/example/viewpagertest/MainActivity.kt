package com.example.viewpagertest

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager)

        viewPager2.offscreenPageLimit = 3
        viewPager2.setPageTransformer(TestPageTransformer(resources))
        val itemDecoration = HorizontalMarginItemDecoration(
            baseContext,
            R.dimen.viewpager_current_item_horizontal_margin
        )
      viewPager2.addItemDecoration(itemDecoration)
        viewPager2.adapter = ViewPagerAdapter(arrayListOf(
            "Current Account" to "10,000 AED",
            "Deposit Account" to "60,000 AED",
            "Savings Account" to "80,000 AED",
            "Current Account" to "100,000 AED",
        ))

    }
}