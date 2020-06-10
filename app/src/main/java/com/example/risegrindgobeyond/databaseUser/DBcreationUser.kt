package com.example.risegrindgobeyond.databaseUser

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.risegrindgobeyond.database.DatabaseColumns

class DBcreationUser(context: Context?):
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    val user_table = "CREATE TABLE ${DatabaseColumnsUser.Table_Name} (${DatabaseColumnsUser.User_Name} TEXT,"+
            "${DatabaseColumnsUser.Password_Name} TEXT)"

    val user_drop = "DROP TABLE IF EXISTS ${DatabaseColumnsUser.Table_Name}"


    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(user_table)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(user_drop)
        onCreate(db)
    }


    companion object{
        const val DB_NAME = "user.db"
        const val DB_VERSION = 1
    }

}