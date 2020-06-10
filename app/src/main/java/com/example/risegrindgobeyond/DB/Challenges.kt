package com.example.risegrindgobeyond.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "challenge_data_table")
data class Challenges (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="challenge_name")
    var id :Int,
    @ColumnInfo(name = "id_challenge")
    var name: String,

    @ColumnInfo(name="challenge_freq")
    var freq: String,

    @ColumnInfo(name="challenge_goal")
    var goal: String,

    @ColumnInfo(name="challenge_desc")
    var desc: String
)
