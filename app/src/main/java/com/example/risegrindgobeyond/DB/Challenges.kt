package com.example.risegrindgobeyond.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "challenge_data_table")
data class Challenges (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="challenge_name")
    val name: String,

    @ColumnInfo(name="challenge_freq")
    val freq: String,

    @ColumnInfo(name="challenge_goal")
    val goal: String,

    @ColumnInfo(name="challenge_desc")
    val desc: String
)
