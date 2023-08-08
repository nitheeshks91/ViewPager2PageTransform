package com.example.viewpagertest

import android.content.res.Resources
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.lang.Math.abs

class TestPageTransformer(resources: Resources) : ViewPager2.PageTransformer {

    val nextItemVisiblePx = resources.getDimension(R.dimen.viewpager_next_item_visible)
    val currentItemHorizontalMarginPx =
        resources.getDimension(R.dimen.viewpager_current_item_horizontal_margin)
    val pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx

    companion object {
        private const val SCALE_MAX = 0.8f
    }

    override fun transformPage(page: View, position: Float) {

        page.translationX = -pageTranslationX * position

        val scale =
            if (position < 0) (1 - SCALE_MAX) * position + 1 else (SCALE_MAX - 1) * position + 1

        if (position < 0) {
            page.pivotX = page.width.toFloat()
        } else {
            page.pivotX = 0f
        }
        page.pivotY = 0f
        page.scaleX = scale
//        page.scaleY = scale

        page.scaleY = 1 - (0.25f * abs(position))
    }
}