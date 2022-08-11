package com.novuspax.androidnotification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.novuspax.androidnotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding :ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            CounterNotificationService(this@MainActivity).showNotification(Counter.value)
        }
    }
}