package com.achiakkon.recyclerviewapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.achiakkon.recyclerviewapp.R
import com.achiakkon.recyclerviewapp.adapters.ChannelAdapter
import com.achiakkon.recyclerviewapp.databinding.ActivityRoomChannelsBinding

class RoomChannelsActivity : AppCompatActivity() {

    lateinit var binding: ActivityRoomChannelsBinding
    private lateinit var vm: RoomChannelsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomChannelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(RoomChannelsViewModel::class.java)

        onClickVolume()

        getRoomName()
        initialiseRv()
        onClickVolume()
    }

    private fun onClickVolume() = with(binding) {
        vm.volumeState.observe(this@RoomChannelsActivity) { volumeState ->
            if (volumeState) {
                ibVolume.setImageResource(R.drawable.ic_volume)
            } else {
                ibVolume.setImageResource(R.drawable.ic_pressed_volume)
            }
        }

        ibVolume.setOnClickListener {
            vm.onClickVolume()
        }
    }

    private fun initialiseRv() {
        val recyclerView = binding.rvChannels
        val adapter = ChannelAdapter()
        recyclerView.adapter = adapter
    }

    private fun getRoomName() = with(binding) {
        tvRoomName.text = intent.extras?.getString("room name").toString()
        when (intent.extras?.getString("room type").toString()) {
            "cash" -> {
                ivType.setImageResource(R.drawable.ic_cash)
                ivType.isVisible = true
            }

            "translation" -> {
                ivType.setImageResource(R.drawable.translate_button)
                ivType.isVisible = true
            }

            else -> ivType.isGone = true
        }
    }
}