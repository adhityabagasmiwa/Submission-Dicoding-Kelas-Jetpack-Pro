package com.adhityabagasmiwa.submissionjetpackpro.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.adhityabagasmiwa.submissionjetpackpro.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(mainLooper).postDelayed({
            val mIntent = Intent(this, HomeActivity::class.java)
            startActivity(mIntent)
            finish()
        }, 5000)
    }
}