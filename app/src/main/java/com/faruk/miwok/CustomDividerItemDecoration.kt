package com.faruk.miwok

import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomDividerItemDecoration(private val divider: Drawable) : RecyclerView.ItemDecoration() {

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val childCount = parent.childCount
        val itemCount = parent.adapter?.itemCount ?: 0

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)

            if (position == RecyclerView.NO_POSITION || position == itemCount - 1) {
                continue // Don't draw after the last item
            }

            val params = child.layoutParams as RecyclerView.LayoutParams
            val left = parent.paddingLeft
            val right = parent.width - parent.paddingRight
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left, top, right, bottom)
            divider.draw(c)
        }
    }
}
