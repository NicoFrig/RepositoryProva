package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val json = resources.openRawResource(R.raw.qualcosa)
        val typeToken = object : TypeToken<List<ItemViewModel>>() {}.type
        val text = json.bufferedReader().use {
            it.readText()
        }
        val itemsList = Gson().fromJson<List<ItemViewModel>>(text, typeToken)

        binding.homeItemRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.homeItemRecyclerview.adapter = ItemAdapter(itemsList)
    }
}