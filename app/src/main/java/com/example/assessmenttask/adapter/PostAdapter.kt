package com.example.assessmenttask.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.data.model.Posts
import com.example.assessmenttask.databinding.PostsModelBinding

class PostAdapter(
    private val onItemClick: (Posts) -> Unit
) : ListAdapter<Posts, PostAdapter.ViewHolder>(PostComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostsModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding,onItemClick = { position ->
            val post = getItem(position)
            if (post != null) {
                onItemClick(post)
            }
        })
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class ViewHolder(
        private val binding: PostsModelBinding,
        private val onItemClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = bindingAdapterPosition
                    onItemClick(position)
                }
            }
        }

        fun bind(item: Posts) {
            binding.title.text = item.title
            binding.body.text = item.body
        }
    }
}