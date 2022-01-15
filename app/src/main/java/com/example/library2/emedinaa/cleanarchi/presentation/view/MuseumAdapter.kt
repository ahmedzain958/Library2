package com.example.library2.emedinaa.cleanarchi.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.library2.R
import com.example.library2.emedinaa.cleanarchi.domain.Museum

/**
 * @author Eduardo Medina
 */
interface Play {
    fun printRorL(textview:TextView)
    fun directTO(museum: Museum)
}

class MuseumAdapter(
    private var museums: List<Museum>,
    private val play: Play
) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_museum, parent, false)
        return MViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MViewHolder, position: Int) {
        viewHolder.bind(museums[position])
    }

    override fun getItemCount(): Int = museums.size

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    inner class MViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewName: TextView = view.findViewById(R.id.textViewName)
        private val imageView: ImageView = view.findViewById(R.id.imageView)
        fun bind(museum: Museum) {
            textViewName.text = museum.name
            Glide.with(imageView.context).load(museum.photo).into(imageView)
            view.setOnClickListener {
//                play.directTO(museum)
                play.printRorL(textViewName)
            }
        }
    }
}