package com.example.pexelsapp.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.pexelsapp.MainActivity
import com.example.pexelsapp.R


// This is the SplashActivity class, which extends the AppCompatActivity
class SplashActivity : AppCompatActivity() {
    // This is the onCreate method, which is called when the activity is created
    override fun onCreate(savedInstanceState: Bundle?) {
        // Call the superclass's onCreate method
        super.onCreate(savedInstanceState)
        // Set the content view to the activity_splash layout
        setContentView(R.layout.activity_splash)

        // Use a Handler to post a delayed Runnable
        Handler().postDelayed({
            // After a 3-second delay, create a new Intent to start the MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Start the MainActivity
            startActivity(intent)
            // Finish the current SplashActivity
            finish()
        }, 3000)
    }
}