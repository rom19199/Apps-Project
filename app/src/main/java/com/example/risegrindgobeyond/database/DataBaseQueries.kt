package com.example.risegrindgobeyond.database

import android.content.ContentValues
import android.content.Context

class DataBaseQueries {
    var sql : DBcreation? = null
    constructor(context: Context){
        sql = DBcreation(context)
    }

    fun addChallenge(name:String, freq:String,goal:String,desc: String):Long{
        val db = sql!!.writableDatabase
        val cv = ContentValues()
        cv.put(DatabaseColumns.Challenge_Name,name)
        cv.put(DatabaseColumns.Challenge_frec,freq)
        cv.put(DatabaseColumns.Challenge_Goal,goal)
        cv.put(DatabaseColumns.Challenge_Desc,desc)
        return db.insert(DatabaseColumns.Table_Name,null,cv)


    }

}