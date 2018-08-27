package com.example.sumitthakur.doordashlite.ui

import android.os.Bundle
import android.view.View

class MainActivity : BaseActivity(), DiscoverFragment.FragmentListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progress_container.visibility = View.VISIBLE
    }

    override fun onSuccess() {
        progress_container.visibility = View.GONE
    }

    override fun onError() {
        progress_container.visibility = View.GONE
        errorText.visibility = View.VISIBLE
    }
}