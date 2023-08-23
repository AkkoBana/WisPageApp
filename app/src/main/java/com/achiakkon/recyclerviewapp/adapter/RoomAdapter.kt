package com.achiakkon.recyclerviewapp.adapter
w
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achiakkon.recyclerviewapp.adapter.Extentions.generateRooms
import com.achiakkon.recyclerviewapp.databinding.ItemLayoutBinding
import com.achiakkon.recyclerviewapp.model.Room

class RoomAdapter(): RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    private val rooms: List<Room> by lazy { generateRooms() }
    lateinit var binding: ItemLayoutBinding

    class RoomViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Room) = with(binding) {

            tvRoomName.text = item.roomName
            if(item.status) {
                imgStatus.setImageIcon(Icon.createWithFilePath("res/drawable/ic_dot.xml"))
            } else {

            }
            when(item.type) {
                "cash" -> imgType.setImageIcon(Icon.createWithFilePath("res/drawable/ic_cash"))
                "translation" -> imgType.setImageIcon(Icon.createWithFilePath("res/drawable/translate_button"))
            }
            if(item.hasMore) {
                imgThreeDots.setImageIcon(Icon.createWithFilePath("res/drawable/ic_dots.xml"))
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.RoomViewHolder {
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RoomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomAdapter.RoomViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    fun getItem(position: Int) : Room = rooms[position]

}
