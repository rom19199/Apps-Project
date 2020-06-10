package com.example.risegrindgobeyond

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.risegrindgobeyond.DB.ChallengeRepository
import com.example.risegrindgobeyond.DB.Challenges
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import androidx.databinding.Observable


class ChallengeViewModel(private val repository: ChallengeRepository) : ViewModel() {

    val challenges= repository.challenges

    @Bindable
    val inputName = MutableLiveData<String>()
    @Bindable
    val inputFrec= MutableLiveData<String>()
    @Bindable
    val inputGoal= MutableLiveData<String>()
    @Bindable
    val inputDesc= MutableLiveData<String>()

    @Bindable
    val saveButton = MutableLiveData<String>()
    @Bindable
    val deleteButton = MutableLiveData<String>()

    init {
        saveButton.value = "save"
        deleteButton.value = "Clear"
    }
    fun saveorUpdate(){
        val name = inputName.value!!
        val frec = inputFrec.value!!
        val goal = inputGoal.value!!
        val desc = inputDesc.value!!

        insert(Challenges(name,frec,goal,desc))
        inputName.value=null
        inputFrec.value= null
        inputGoal.value=null
        inputDesc.value=null

    }
    fun clearorDelete(){
        clearAll()

    }
    fun insert(challenge:Challenges):Job = viewModelScope.launch {
        repository.insert(challenge)
    }
    fun update(challenge:Challenges):Job = viewModelScope.launch {
        repository.update(challenge)
    }
    fun delete(challenge:Challenges):Job = viewModelScope.launch {
        repository.delete(challenge)
    }
    fun clearAll():Job = viewModelScope.launch {
        repository.deleteAll()
    }




}

