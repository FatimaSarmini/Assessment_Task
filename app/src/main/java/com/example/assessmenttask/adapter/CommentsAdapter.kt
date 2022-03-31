package com.example.assessmenttask.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.R
import com.example.assessmenttask.data.model.Comments
import com.example.assessmenttask.databinding.CommentsModelBinding
import org.w3c.dom.Comment

class CommentsAdapter: ListAdapter<Comments, CommentsAdapter.ViewHolder>(CommentComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CommentsModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class ViewHolder(
        private val binding: CommentsModelBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(comment: Comments) {
            binding.email.text = comment.email
            binding.comment.text = comment.body
        }
    }
}
