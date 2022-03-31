package com.example.assessmenttask.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.assessmenttask.data.model.Posts

class PostComparator : DiffUtil.ItemCallback<Posts>() {

    override fun areItemsTheSame(oldItem: Posts, newItem: Posts) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Posts, newItem: Posts) =
        oldItem == newItem
}