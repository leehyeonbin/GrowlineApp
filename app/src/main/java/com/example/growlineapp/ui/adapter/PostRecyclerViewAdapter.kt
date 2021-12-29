package com.example.growlineapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.growlineapp.R
import com.example.growlineapp.data.model.Post
import com.example.growlineapp.data.model.Post_list

class PostRecyclerViewAdapter(private val list : ArrayList<Post>): RecyclerView.Adapter<PostRecyclerViewAdapter.PostViewHolder>() {
    inner class PostViewHolder(val v : View) : RecyclerView.ViewHolder(v) {
        val title = v.findViewById<TextView>(R.id.title_tv)
        val content = v.findViewById<TextView>(R.id.content_tv)
        val date = v.findViewById<TextView>(R.id.date_tv)
        val view = v.findViewById<TextView>(R.id.view_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.noticeboard_item_list, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.apply {
            title.text = list[position].title
            content.text = list[position].content
            date.text = list[position].date
            view.text = list[position].view
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}