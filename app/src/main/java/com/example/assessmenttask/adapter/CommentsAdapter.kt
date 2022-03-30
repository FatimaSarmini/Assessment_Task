package com.example.assessmenttask.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.R
import com.example.assessmenttask.data.model.Comments

class CommentsAdapter(private val commentsList: List<Comments>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.comments_model,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return commentsList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${commentsList.size} ")
            holder.email.text = commentsList[position].email
            holder.body.text = commentsList[position].body
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var email = itemView.findViewById<TextView>(R.id.email)
        var body = itemView.findViewById<TextView>(R.id.comment)

        }

    }
