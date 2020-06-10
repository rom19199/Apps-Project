package com.example.risegrindgobeyond.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database   (entities = [Challenges::class],version = 1)
abstract class ChallengeDataBase: RoomDatabase() {

    abstract val ChallengeDao: challengeDAO

    companion object{
        @Volatile
        private var INSTANCE: ChallengeDataBase? = null
            fun getInstance(context:Context): ChallengeDataBase{
                synchronized(this){
                    var instance = INSTANCE
                        if(instance==null){
                            instance= Room.databaseBuilder(
                                context.applicationContext,
                                ChallengeDataBase::class.java,
                                "challenge_data_database"
                        ).build()
                    }
                    return  instance

            }
        }
    }
}