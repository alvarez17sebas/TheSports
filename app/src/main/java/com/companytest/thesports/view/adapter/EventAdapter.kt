package com.companytest.thesports.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companytest.thesports.databinding.ItemEventBinding
import com.companytest.thesports.model.Event

class EventAdapter(var data: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemEventBinding = ItemEventBinding.inflate(inflater)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event: Event = data[position]
        holder.bindData(event)
    }

    inner class EventViewHolder(rowBinding: ItemEventBinding) :
        RecyclerView.ViewHolder(rowBinding.root) {

        private var itemBinding: ItemEventBinding = rowBinding

        fun bindData(event: Event) {
            itemBinding.tvEventNameItem.text = event.strEvent
        }
    }
}