package com.example.risegrindgobeyond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_challenge_progress.*

class ChallengeProgress : AppCompatActivity() {

    companion object{
        lateinit var dBhandler: DBhandler
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge_progress)

        dBhandler = DBhandler(this, null,null, 1)
        viewChallenges()

        btnADD.setOnClickListener{
            val i = Intent(this,Challenge_Creation::class.java)
            startActivity(i)

        }




    }

    private fun viewChallenges(){
        val challengeList:ArrayList<Models> = dBhandler.getChallenges(this)
        val adapter = ChallengeAdapter(this,challengeList)
        val rv:RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false) as RecyclerView.LayoutManager
        rv.adapter = adapter

    }

    override fun onResume() {
        viewChallenges()
        super.onResume()
    }
}
