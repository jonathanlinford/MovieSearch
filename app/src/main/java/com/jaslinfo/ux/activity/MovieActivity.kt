package com.jaslinfo.ux.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jaslinfo.ux.R

import kotlinx.android.synthetic.main.activity_movie.*

class MovieActivity : AppCompatActivity() {

    companion object {
        private var EXTRA_TITLE: String = "EXTRA_TITLE"

        fun newIntent(context: Context, title: String): Intent {
            return Intent(context, MovieActivity::class.java).apply {
                putExtra(EXTRA_TITLE, title)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        setupActionBar(intent.getStringExtra(EXTRA_TITLE))
    }

    private fun setupActionBar(title: String){
        setSupportActionBar(toolbar)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white)
        toolbar.title = title
        toolbar.setNavigationOnClickListener {
            onNavigateUp()
        }
    }

    override fun onNavigateUp(): Boolean {
        this.onBackPressed()
        return super.onNavigateUp()
    }
}
