package com.achiakkon.recyclerviewapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.achiakkon.recyclerviewapp.Extentions.generateChannels
import com.achiakkon.recyclerviewapp.R
import com.achiakkon.recyclerviewapp.databinding.ItemChannelLayoutBinding
import com.achiakkon.recyclerviewapp.model.Channel

class ChannelAdapter() : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>() {

    private val channels: List<Channel> by lazy { generateChannels() }
    lateinit var binding: ItemChannelLayoutBinding

    class ChannelViewHolder(private val binding: ItemChannelLayoutBinding):
        RecyclerView.ViewHolder(binding.root) {



        fun bind(item: Channel) = with(binding) {

            var state = item.microphoneState

            ibState.setOnClickListener {
                if(state){
                    tvState.text = "Stop"
                    ibState.setImageResource(R.drawable.ic_microfone_working)
                    state = false
                } else {
                    tvState.text = "Play"
                    ibState.setImageResource(R.drawable.ic_microfone)
                    state = true
                }

            }

            tvChannelName.text = item.channelName
            if (state) {
                tvState.text = "Play"
                ibState.setImageResource(R.drawable.ic_microfone)
            }

        }


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChannelAdapter.ChannelViewHolder {
        binding =
            ItemChannelLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChannelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChannelAdapter.ChannelViewHolder, position: Int) {
        holder.bind(channels[position])
    }

    override fun getItemCount(): Int {
        return channels.size
    }
}