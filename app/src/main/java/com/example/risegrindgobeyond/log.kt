package com.example.risegrindgobeyond

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.example.risegrindgobeyond.databaseUser.DataBaseQueriesUser
import kotlinx.android.synthetic.main.activity_register.*

class log : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var pass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log)

        name=findViewById(R.id.editTextNAME)
        pass= findViewById(R.id.editTextPASS)
    }
    fun log(v:View){
        val db=DataBaseQueriesUser(this)
        val res = db.login(name.text.toString(),pass.text.toString())
        if(res.moveToFirst()){
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Message")
                .setMessage("Log in Succesfully")
                .setPositiveButton("ok",null)
                .show()
            val intent : Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }else{
            AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher_round)
                .setTitle("Alert!")
                .setMessage("Log not Succesfully, \n try again")
                .setPositiveButton("ok",null)
                .show()

        }

    }

}
