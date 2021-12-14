package com.example.library2.mvvm2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.library2.databinding.RowMuseumBinding
import com.example.library2.mvvm2.model.Museum

/**
 * @author Eduardo Medina
 */
class MuseumAdapter(private var museums: List<Museum>) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val itemBinding =
            RowMuseumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: MViewHolder, position: Int) {
        viewHolder.bind(museums[position])
    }

    override fun getItemCount(): Int = museums.size

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    class MViewHolder(itemBinding: RowMuseumBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        private val textViewName: TextView = itemBinding.textViewName
        private val imageView: ImageView = itemBinding.imageView

        fun bind(museum: Museum) {
            textViewName.text = museum.name
            Glide.with(imageView.context).load(museum.photo).into(imageView)
        }
    }
}