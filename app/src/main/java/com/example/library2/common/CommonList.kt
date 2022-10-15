package com.example.library2.common

import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.library2.R

class CommonList @JvmOverloads constructor(
     context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val mAdapter by lazy { CommonListAdapter(dataList, ::onItemClicked) }
    private val dataList = mutableListOf<String>()

    private var activityItemsList: (List<Pair<String, Class<out AppCompatActivity>>>)? = null
    private var fragmentItemsList: (List<Pair<String,Fragment>>)? = null


    init {

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val root = inflater.inflate(R.layout.common_list, this)

        val rv = root.findViewById<RecyclerView>(R.id.rvList)
        rv.adapter = mAdapter
    }


    /**
     * Update list with fragments or activities with their titles
     *
     * You should provide only one list of them, precedence is for fragments.
     */
    fun updateData(
        activityItemsList: (List<Pair<String, Class<out AppCompatActivity>>>)? = null,
        fragmentItemsList: (List<Pair<String, Fragment>>)? = null
    ) {
        this.activityItemsList = activityItemsList
        this.fragmentItemsList = fragmentItemsList

        dataList.clear()
        activityItemsList?.let {
            dataList.addAll(it.map { it.first })
        }

        fragmentItemsList?.let {
            dataList.addAll(it.map { it.first })
        }
        mAdapter.updateMainListItems(dataList)
    }

    private fun onItemClicked(position: Int) {
       fragmentItemsList?.get(position)?.second?.let { fragment ->

            (context as AppCompatActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer ,fragment )
                .addToBackStack(null)
                .commit()
        } ?: openActivity(position)
    }

    private fun openActivity(position: Int) {
        val dstActivity = activityItemsList?.getOrNull(position)?.second ?: return
        val intent = Intent(context, dstActivity)
        context.startActivity(intent)
    }
}