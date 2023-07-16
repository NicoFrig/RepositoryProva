package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.prova.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemName = intent.getStringExtra("name")
        val itemUrl = intent.getStringExtra("url")
        val itemDetail = intent.getStringExtra("details")

        itemName ?.let {
            itemUrl ?.let {
                itemDetail ?.let {
                    binding.detailNameTextview.text = itemName
                    Picasso.get().load(itemUrl).into(binding.detailImageviewImageview)
                    binding.detailDetailsTextview.text = itemDetail
                }
            }
        }
        onBackPressedDispatcher.addCallback(object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                finish()
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            }
        })
    }

}
