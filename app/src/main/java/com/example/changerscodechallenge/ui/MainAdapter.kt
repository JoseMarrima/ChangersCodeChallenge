package com.example.changerscodechallenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.changerscodechallenge.databinding.ItemDogBinding
import com.example.changerscodechallenge.model.DogsItem

class MainAdapter: ListAdapter<DogsItem, RecyclerView.ViewHolder>(DataDiffCallback()) {

    class MainViewHolder(private val binding: ItemDogBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DogsItem) {
            binding.apply {
                 dog = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder(ItemDogBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        ))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MainViewHolder).bind(getItem(position))
    }
}