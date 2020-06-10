package com.example.risegrindgobeyond.DB

class ChallengeRepository (private val dao:challengeDAO){

    val challenges= dao.getAllChallenges()

    suspend fun insert(challenge:Challenges){
         dao.insertChallenge(challenge)
    }

    suspend fun update(challenge:Challenges){
        dao.updateChallenge(challenge)
    }

    suspend fun delete(challenge: Challenges){
        dao.deleteChallenge(challenge)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }
}