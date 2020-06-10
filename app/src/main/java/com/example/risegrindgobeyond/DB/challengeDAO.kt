package com.example.risegrindgobeyond.DB

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface challengeDAO {

    @Insert
    suspend fun insertChallenge(challenge:Challenges): Long

    @Update
    suspend fun updateChallenge(challenge: Challenges)

    @Delete
    suspend fun deleteChallenge(challenge: Challenges)

    @Query("DELETE FROM challenge_data_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM challenge_data_table")
    fun getAllChallenges():LiveData<List<Challenges>>



}