package com.faruk.miwok

import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    override fun onPause() {
        super.onPause()
        MediaPlayerManager.release()  // Stop and release audio when user leaves the fragment
    }
}
