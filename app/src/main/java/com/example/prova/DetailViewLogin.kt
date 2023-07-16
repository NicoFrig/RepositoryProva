package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova.databinding.ActivityDetailViewLoginBinding
import com.example.prova.databinding.ActivityLoginBinding

class DetailViewLogin : AppCompatActivity() {
    private lateinit var binding: ActivityDetailViewLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_view_login)
        binding = ActivityDetailViewLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.emailText.text = intent.getStringExtra("emailText")
    }
}