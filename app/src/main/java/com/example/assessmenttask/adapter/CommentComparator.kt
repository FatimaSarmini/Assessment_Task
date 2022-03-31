package com.example.assessmenttask.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.assessmenttask.data.model.Comments

class CommentComparator : DiffUtil.ItemCallback<Comments>() {

    override fun areItemsTheSame(oldItem: Comments, newItem: Comments) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Comments, newItem: Comments) =
        oldItem == newItem
}