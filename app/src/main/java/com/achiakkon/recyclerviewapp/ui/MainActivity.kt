package com.achiakkon.recyclerviewapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.achiakkon.recyclerviewapp.adapters.RoomAdapter
import com.achiakkon.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        val adapter = initialiseRv()
        addRoom(adapter)
        setupTopBar()
    }

    private fun initialiseRv(): RoomAdapter {
        val list = binding.rvRooms
        val adapter = RoomAdapter {
            val intent: Intent = Intent(this@MainActivity, RoomChannelsActivity::class.java)
            intent.putExtra("room name", it.roomName)
            intent.putExtra("room type", it.type)
            startActivity(intent)
        }
        list.adapter = adapter
        return adapter
    }

    private fun addRoom(adapter: RoomAdapter) {
        vm.roomsList.observe(this) {
            adapter.addToRoomsList(it)
        }

        binding.ibAddRoom.setOnClickListener {
            vm.addRoom()
        }
    }

    private fun setupTopBar() = with(binding) {
        vm.appBarState.observe(this@MainActivity) { appBarState ->
            if(appBarState) {
                appBar.isVisible = false
                etSearch.isVisible = true
                ibCloseSearch.isVisible = true
            } else  {
                etSearch.isVisible = false
                ibCloseSearch.isVisible = false
                appBar.isVisible = true
            }
        }

        ibOpenSearch.setOnClickListener {
            vm.setupAppBar()
        }
        ibCloseSearch.setOnClickListener {
            vm.setupAppBar()
        }
    }


}