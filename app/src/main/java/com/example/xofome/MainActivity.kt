package com.example.xfome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.xfome.databinding.ActivityMainBinding
import com.example.xofome.LazerActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private  lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bt = binding.button
        val ed = binding.editTextTextPersonName
        val senha = binding.editTextTextPassword


        bt.setOnClickListener{
            val database = Firebase.database
            val myRef = database.getReference("message")

            myRef.setValue("Hello, World!")

            if (ed.text.toString().equals("adriano") && senha.text.toString().equals("1234")){
                val texto = ed.text.toString()
                val intent = Intent(this, LazerActivity::class.java)
                intent.putExtra("user", texto)
                startActivity(intent)
            }else{
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
            }
        }

        //setContentView(R.layout.activity_main)
    }
}