package com.example.xofome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.xfome.databinding.ActivityAboutBinding
import com.example.xofome.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAboutBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //setContentView(R.layout.activity_about)
    }
}