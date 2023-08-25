package com.achiakkon.recyclerviewapp

import com.achiakkon.recyclerviewapp.model.Channel
import com.achiakkon.recyclerviewapp.model.Room

object Extentions {
    fun generateRooms(): List<Room> = listOf(
        Room("Room 1", "cash", true, true),
        Room("Room 2", "cash", false, false),
        Room("Room 3", "translation", false, false),
        Room(
            "Room 4 Room 4 Room 4 Room 4 Room 4 Room 4 Room 4",
            "cash",
            true,
            true
        ),
        Room("Room 5", "nothing", true, false),
        Room("Room 7", "translation", true, true),
        Room("Room 8", "translation", false, false),
        Room("Room 9", "translation", false, false),
        Room("Room 10", "translation", true, false),
    )

    fun generateChannels(): List<Channel> = listOf (
        Channel("Russian", false),
        Channel("English", false)
            )

}