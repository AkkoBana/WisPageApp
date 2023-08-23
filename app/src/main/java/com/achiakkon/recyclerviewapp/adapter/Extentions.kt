package com.achiakkon.recyclerviewapp.adapter

import com.achiakkon.recyclerviewapp.model.Room

object Extentions {
    fun generateRooms(): List<Room> = listOf(
        Room("Room 1", "cash", true, true),
        Room("Room 2", "cash", false, false),
        Room("Room 3", "translation", false, false),
        Room(
            "Room 4thhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh",
            "nothing",
            false,
            true
        ),
        Room("Room 5", "nothing", true, false),
        Room("Room 6", "translation", true, true),
    )
}