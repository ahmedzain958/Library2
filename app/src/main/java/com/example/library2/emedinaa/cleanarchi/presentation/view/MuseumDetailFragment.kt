package com.example.library2.emedinaa.cleanarchi.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.library2.R
import com.example.library2.emedinaa.cleanarchi.domain.Museum


class MuseumDetailFragment : Fragment() {
   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View {
       return inflater.inflate(R.layout.fragment_museum_detail, container, false)
   }

    private fun populate(museum: Museum, view: View) {
        view.findViewById<TextView>(R.id.textView).text = museum.name
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        Glide.with(imageView.context).load(museum.photo).into(imageView)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<Museum>("MUSEUM")?.let {
            populate(it, view)
        }
    }
}