package com.achiakkon.recyclerviewapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.achiakkon.recyclerviewapp.R
import com.achiakkon.recyclerviewapp.adapters.Extentions.generateRooms
import com.achiakkon.recyclerviewapp.databinding.ItemLayoutBinding
import com.achiakkon.recyclerviewapp.model.Room

class RoomAdapter(private val onItemClick: (Int) -> Unit): RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    private val rooms: List<Room> by lazy { generateRooms() }
    lateinit var binding: ItemLayoutBinding

    class RoomViewHolder(private val binding: ItemLayoutBinding, private val onItemClick: (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Room) = with(binding) {
            tvRoomName.text = item.roomName

            ivStatus.setOnClickListener {
                onItemClick.invoke(layoutPosition)
            }

            when(item.type) {
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
            if(item.hasMore) {
                ivThreeDots.setImageResource(R.drawable.ic_dots)
                ivThreeDots.isVisible = true
            } else {
                ivThreeDots.isGone = true
            }
            if(item.status) {
                ivStatus.setImageResource(R.drawable.ic_dot)
                ivStatus.isVisible = true
            } else {
                ivStatus.isGone = true
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.RoomViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)  {
            onItemClick.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: RoomAdapter.RoomViewHolder, position: Int) {
        holder.bind(rooms[position])
    }

    override fun getItemCount(): Int {
        return rooms.size
    }
}
