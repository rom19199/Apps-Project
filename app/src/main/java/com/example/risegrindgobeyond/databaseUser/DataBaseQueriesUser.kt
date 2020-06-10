package com.example.risegrindgobeyond.databaseUser

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.risegrindgobeyond.database.DBcreation
import com.example.risegrindgobeyond.database.DatabaseColumns

class DataBaseQueriesUser {
    var sql : DBcreationUser? = null
    constructor(context: Context) {
        sql = DBcreationUser(context)
    }
    fun addUser(userName:String, password:String):Long{
        val db = sql!!.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumnsUser.User_Name, userName)
        cv.put(DatabaseColumnsUser.Password_Name,password)
        return db.insert(DatabaseColumnsUser.Table_Name,null,cv)


    }
    fun login(userName: String, password: String): Cursor{
        val db = sql!!.readableDatabase
        return db.query(DatabaseColumnsUser.Table_Name,null,DatabaseColumnsUser.User_Name+"=? AND "+DatabaseColumnsUser.Password_Name+"=?",
            arrayOf(userName,password),null,null,null)

    }


}