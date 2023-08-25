package com.achiakkon.recyclerviewapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.achiakkon.recyclerviewapp.adapters.RoomAdapter
import com.achiakkon.recyclerviewapp.databinding.ActivityMainBinding
import com.achiakkon.recyclerviewapp.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        initRc()
        setupTopBar()
    }

    private fun initialiseRv() {
        val list = binding.rvRooms
        val adapter = RoomAdapter {
            val intent: Intent = Intent(this@MainActivity, ItemInfo::class.java)
            intent.putExtra("itemNumber", it + 1)
            startActivity(intent)
        }
        list.adapter = adapter
    }

    private fun setupTopBar() = with(binding) {
        ibOpenSearch.setOnClickListener {
            appBar.isVisible = false
            etSearch.isVisible = true
            ibCloseSearch.isVisible = true
        }
        ibCloseSearch.setOnClickListener {
            etSearch.isVisible = false
            ibCloseSearch.isVisible = false
            appBar.isVisible = true
        }
    }


}