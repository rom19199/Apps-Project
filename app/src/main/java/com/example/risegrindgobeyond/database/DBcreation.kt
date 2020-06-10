package com.example.risegrindgobeyond.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBcreation(context: Context?):
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val challenge_table = "CREATE TABLE ${DatabaseColumns.Table_Name} (${DatabaseColumns.Challenge_Name} TEXT,"+
                            "${DatabaseColumns.Challenge_frec} TEXT, ${DatabaseColumns.Challenge_Goal} TEXT, ${DatabaseColumns.Challenge_Desc} TEXT)"

    val challenge_drop = "DROP TABLE IF EXISTS ${DatabaseColumns.Table_Name}"


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(challenge_table)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(challenge_drop)
        onCreate(db)
    }


    companion object{
        const val DB_NAME = "challenge.db"
        const val DB_VERSION = 1
    }

}