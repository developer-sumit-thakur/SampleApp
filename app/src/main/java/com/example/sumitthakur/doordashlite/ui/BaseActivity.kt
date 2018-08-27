package com.example.sumitthakur.doordashlite.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import android.widget.TextView
import com.example.sumitthakur.doordashlite.R

open class BaseActivity : AppCompatActivity() {

    lateinit var errorText: TextView

    lateinit var container: FrameLayout

    lateinit var progress_container: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        errorText = findViewById(R.id.error_text)
        container = findViewById(R.id.fragment_container)
        progress_container = findViewById(R.id.loadingBar)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    DiscoverFragment(), DiscoverFragment.TAG).commit()
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }
}