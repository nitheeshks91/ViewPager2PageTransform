package com.example.viewpagertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    private val data: MutableList<Pair<String, String>>,
) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = inflater.inflate(R.layout.pager_item, parent, false)
        return ViewPagerHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(data[position].first, data[position].second)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewPagerHolder(binding: View) :
        RecyclerView.ViewHolder(binding) {
        var titleView: TextView? = null
        var descView: TextView? = null

        init {
            titleView = binding.findViewById(R.id.title)
            descView = binding.findViewById(R.id.description)
        }

        fun bind(title: String, desc: String) {
            titleView?.text = title
            descView?.text = desc
        }
    }
}
