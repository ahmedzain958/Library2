package com.example.library2.common

import androidx.recyclerview.widget.RecyclerView
import com.example.library2.databinding.CommonListItemBinding


class ItemViewHolder(private val binding: CommonListItemBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bindMainListItems(dataItem: String) {
        binding.tvTitle.text = dataItem
    }
}