package com.achiakkon.recyclerviewapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.achiakkon.recyclerviewapp.adapters.ChannelAdapter

class RoomChannelsViewModel() : ViewModel() {
    private val _volumeState = MutableLiveData<Boolean>()
    val volumeState: LiveData<Boolean> get() = _volumeState

    init {
        _volumeState.value = true
    }

    fun onClickVolume() {
        _volumeState.value = !_volumeState.value!!
    }

}
