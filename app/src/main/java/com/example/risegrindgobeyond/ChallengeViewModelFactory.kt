package com.example.risegrindgobeyond

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.risegrindgobeyond.DB.ChallengeRepository
import java.lang.IllegalArgumentException

class ChallengeViewModelFactory(private val repository: ChallengeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ChallengeViewModel::class.java)){
            return  ChallengeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown view model class")

    }
}