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
import androidx.lifecycle.LiveData


class ChallengeViewModel(private val repository: ChallengeRepository) : ViewModel(), Observable {

    val challenges= repository.challenges
    private var isUpdateorDelete = false
    private lateinit var challengeToUpdateOrDelete:Challenges

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

    private  val statusMessage = MutableLiveData<Event<String>>()
    val message : LiveData<Event<String>>
        get() = statusMessage


    init {
        saveButton.value = "save"
        deleteButton.value = "Clear"
    }
    fun saveorUpdate(){
        if(isUpdateorDelete){
            challengeToUpdateOrDelete.name = inputName.value!!
            challengeToUpdateOrDelete.freq = inputFrec.value!!
            challengeToUpdateOrDelete.goal = inputGoal.value!!
            challengeToUpdateOrDelete.desc = inputDesc.value!!
            update(challengeToUpdateOrDelete)
        }else {


            val name = inputName.value!!
            val frec = inputFrec.value!!
            val goal = inputGoal.value!!
            val desc = inputDesc.value!!

            insert(Challenges(0, name, frec, goal, desc))
            inputName.value = null
            inputFrec.value = null
            inputGoal.value = null
            inputDesc.value = null
        }

    }
    fun clearorDelete(){
        if(isUpdateorDelete){
            delete(challengeToUpdateOrDelete)
        }else{
            clearAll()

        }


    }
    fun insert(challenge:Challenges):Job = viewModelScope.launch {
        repository.insert(challenge)
        statusMessage.value = Event("Challenge inserted Succesfully")
    }
    fun update(challenge:Challenges):Job = viewModelScope.launch {
        repository.update(challenge)
        inputName.value = null
        inputFrec.value = null
        inputGoal.value = null
        inputDesc.value = null
        isUpdateorDelete = false
        saveButton.value =  "Save"
        deleteButton.value = "Clear all"
        statusMessage.value = Event("Challenge updated Succesfully")


    }
    fun delete(challenge:Challenges):Job = viewModelScope.launch {
        repository.delete(challenge)
        inputName.value = null
        inputFrec.value = null
        inputGoal.value = null
        inputDesc.value = null
        isUpdateorDelete = false
        saveButton.value =  "Save"
        deleteButton.value = "Clear all"
        statusMessage.value = Event("Challenge deleted Succesfully")

    }
    fun clearAll():Job = viewModelScope.launch {
        repository.deleteAll()
        statusMessage.value = Event("All Challenges deleted Succesfully")


    }
    fun initUpdateandDelete(challenge: Challenges){
        inputName.value = challenge.name
        inputFrec.value = challenge.freq
        inputGoal.value = challenge.goal
        inputDesc.value = challenge.desc
        isUpdateorDelete = true
        challengeToUpdateOrDelete = challenge
        saveButton.value =  "Update"
        deleteButton.value = "Delete"

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}

