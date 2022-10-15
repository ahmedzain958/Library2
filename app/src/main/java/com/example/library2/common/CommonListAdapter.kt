package com.example.library2.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.library2.databinding.CommonListItemBinding

class CommonListAdapter(private var list: List<String> = emptyList() , private val onClick : (Int) -> Unit) :
    RecyclerView.Adapter<ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            CommonListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener {
                onClick.invoke(bindingAdapterPosition)
            }
        }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindMainListItems(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun updateMainListItems(newList: List<String>) {
        list = newList
    }

}