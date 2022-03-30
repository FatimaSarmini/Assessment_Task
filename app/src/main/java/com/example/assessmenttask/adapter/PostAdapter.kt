package com.example.assessmenttask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.R
import com.example.assessmenttask.data.model.Posts


class PostAdapter(private val postsList: List<Posts>, val clickListner: OnPostClickedListener ) :RecyclerView.Adapter<PostAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view  = LayoutInflater.from(parent.context).inflate(R.layout.posts_model,parent,false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
        return postsList.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.title.text = postsList[position].title
//        holder.body.text = postsList[position].body

        holder.initialize(postsList[position], clickListner)
    }




    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var body = itemView.findViewById<TextView>(R.id.body)

        fun initialize(item: Posts, action: OnPostClickedListener){
            title.text = item.title
            body.text = item.body

            itemView.setOnClickListener{
                action.onItemClick(item, bindingAdapterPosition)
            }
        }
    }


    interface OnPostClickedListener{
        fun onItemClick(item: Posts, position: Int)
    }
}