package com.example.risegrindgobeyond

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.lang.Exception
import java.util.prefs.PreferencesFactory

class DBhandler(context : Context, name: String?, factory: SQLiteDatabase.CursorFactory?, version:  Int ):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object{
        private val DATABASE_NAME = "MyData.db"
        private val DATABASE_VERSION = 1

        val CHALLENGE_TABLE_NAME = "Challenges"
        val COLUMN_Challenge_NAME = "ChallengesNAME"
        val COLUMN_Challenge_Frec = "ChallengeFrec"
        val COLUMN_Challenge_Goal = "ChallengeGoal"
        val COLUMN_Challenge_Descrep = "ChallengeDesc"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CHALLENGE_TABLE= ("CREATE TABLE $CHALLENGE_TABLE_NAME ("+
                "$COLUMN_Challenge_NAME TEXT    ,"+
                "$COLUMN_Challenge_Frec TEXT,"+
                "$COLUMN_Challenge_Goal TEXT,"+
                "$COLUMN_Challenge_Descrep TEXT)")

        db?.execSQL(CREATE_CHALLENGE_TABLE)

    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun getChallenges(mCtx: Context):ArrayList<Models> {
        val qry = "Select * From $CHALLENGE_TABLE_NAME"
        val db:SQLiteDatabase= this.readableDatabase
        val cursor = db.rawQuery(qry, null)
        val challenges = ArrayList<Models>()

        if (cursor.count == 0)
            Toast.makeText(mCtx, "No records found", Toast.LENGTH_SHORT).show() else {
            while (cursor.moveToNext()) {
                val challenge1 = Models()
                challenge1.ChallengeName = cursor.getString(cursor.getColumnIndex(COLUMN_Challenge_NAME))
                challenge1.ChallengeFrec = cursor.getString(cursor.getColumnIndex(COLUMN_Challenge_Frec))
                challenge1.ChallengeGoal = cursor.getString(cursor.getColumnIndex(COLUMN_Challenge_Goal))
                challenge1.ChallengeDesc = cursor.getString(cursor.getColumnIndex(COLUMN_Challenge_Descrep))
                challenges.add(challenge1)


            }
            Toast.makeText(mCtx, "${cursor.count.toString()} Records Found", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db.close()
        return challenges

    }
    fun addChallenges(mCtx: Context, challenge1: Models){
        val values = ContentValues()
        values.put(COLUMN_Challenge_NAME,challenge1.ChallengeName)
        values.put(COLUMN_Challenge_Frec,challenge1.ChallengeFrec)
        values.put(COLUMN_Challenge_Goal,challenge1.ChallengeGoal)
        values.put(COLUMN_Challenge_Descrep,challenge1.ChallengeDesc)
        val db : SQLiteDatabase= this.writableDatabase
        try{
            db.insert(CHALLENGE_TABLE_NAME, null,values)
            //db.rawQuery("Insert Into $CHALLENGE_TABLE_NAME($COLUMN_Challenge_NAME, $COLUMN_Challenge_Frec, $COLUMN_Challenge_Goal, $COLUMN_Challenge_Descrep) Values(?,?)")
            Toast.makeText(mCtx,"Challenge Added", Toast.LENGTH_SHORT).show()

        }catch (e:Exception){
            Toast.makeText(mCtx, e.message, Toast.LENGTH_SHORT).show()

        }
        db.close()

    }

}