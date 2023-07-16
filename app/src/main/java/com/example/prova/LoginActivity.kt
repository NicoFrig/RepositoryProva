package com.example.prova

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prova.databinding.ActivityLoginBinding
import com.example.prova.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fun checkEmail():Boolean {
            var flag = false
            val email = binding.loginText.text.toString()
            if(email.isNotEmpty()){
                if(email.length >= 8) {
                    flag = true
                }
                else{
                    Toast.makeText(this, "La mail deve avere almeno 8 caratteri", Toast.LENGTH_SHORT).show()
                }
            }
            return flag
        }
        fun checkPassword():Boolean {
            var flag = false
            val password = binding.loginText.text.toString()
            if(password.isNotEmpty()){
                if(password.length >= 8) {
                    flag = true
                }
                else{
                    Toast.makeText(this, "La password deve avere almeno 8 caratteri", Toast.LENGTH_SHORT).show()
                }
            }
            return flag
        }
        binding.submit.setOnClickListener{
            var email = checkEmail()
            var password = checkPassword()
            if(email && password) {
                val intent = Intent(this,DetailViewLogin::class.java )
                intent.putExtra("emailText", binding.loginText.text.toString())
                startActivity(intent)
            }
        }
    }
}