package com.example.risegrindgobeyond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.risegrindgobeyond.database.DataBaseQueries
import com.example.risegrindgobeyond.databaseUser.DataBaseQueriesUser

class Register : AppCompatActivity() {

    lateinit var UserName : EditText
    lateinit var UserPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        UserName = findViewById(R.id.editTextName)
        UserPassword = findViewById(R.id.editTextPassword)
    }

    fun addUser(v: View){
        val db = DataBaseQueriesUser(this)
        val res = db.addUser(UserName.text.toString(),UserPassword.text.toString())
        if(res >0){
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("User Added")
                .setPositiveButton("Ok",null)
                .show()

        }else{
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert")
                .setMessage("Something is wrong , \n Please Try again")
                .setPositiveButton("Ok",null)
                .show()

        }


    }
    fun login(v:View) {
        val intent: Intent = Intent(this, log::class.java)
        startActivity(intent)
        finish()
    }
}
