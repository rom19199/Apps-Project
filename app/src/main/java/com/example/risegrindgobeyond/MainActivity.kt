package com.example.risegrindgobeyond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonNewChallenge.setOnClickListener(){
            val intent :Intent = Intent(this, Challenge_Creation::class.java)
            startActivity(intent)
        }

        btnRegister.setOnClickListener(){
            val intent :Intent = Intent(this, Register::class.java)
            startActivity(intent)
        }



    }
}
