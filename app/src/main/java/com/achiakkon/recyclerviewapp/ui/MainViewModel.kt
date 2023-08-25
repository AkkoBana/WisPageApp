package com.achiakkon.recyclerviewapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.achiakkon.recyclerviewapp.Extentions.generateRooms
import com.achiakkon.recyclerviewapp.model.Room

class MainViewModel : ViewModel() {

    private val _appBarState = MutableLiveData<Boolean>()
    val appBarState: LiveData<Boolean> get() = _appBarState

    private val _roomsList = MutableLiveData<MutableList<Room>>()
    val roomsList: LiveData<MutableList<Room>> get() = _roomsList

    init {
        _appBarState.value = false
        _roomsList.value = generateRooms().toMutableList()
    }

    fun setupAppBar() {
        _appBarState.value = !_appBarState.value!!
    }

    fun addRoom() {
        _roomsList.value?.add(Room("Room 11", "nothing", false, false))
        _roomsList.value = _roomsList.value
    }

}