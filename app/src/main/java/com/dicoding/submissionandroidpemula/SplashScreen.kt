package com.dicoding.submissionandroidpemula

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.os.Handler
import android.widget.ProgressBar

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIMEOUT: Long = 3000 // 3 detik
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = ProgressBar.VISIBLE

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMEOUT)
    }
}
