package com.achiakkon.recyclerviewapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.achiakkon.recyclerviewapp.adapter.RoomAdapter
import com.achiakkon.recyclerviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = binding.rvRooms
        val adapter = RoomAdapter()
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }


    private fun openSearch() {
        binding.btnSearch.setOnClickListener {

        }
    }

}