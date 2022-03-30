package com.example.assessmenttask.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmenttask.adapter.PostAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.R
import com.example.assessmenttask.data.api.RetrofitBuilder
import com.example.assessmenttask.data.api.ApiService
import com.example.assessmenttask.data.model.Posts
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class PostsTab : Fragment(), PostAdapter.OnPostClickedListener {

    private lateinit var postsList: RecyclerView

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        var v = inflater.inflate(R.layout.fragment_posts_tab, container, false)
        postsList = v.findViewById<RecyclerView?>(R.id.postsList)
        loadPosts(postsList)
        return v
    }


    private fun loadPosts(postsList: RecyclerView) {
        //initiate the service
        val destinationService = RetrofitBuilder.buildService(ApiService::class.java)
        val requestCall = destinationService.getPostList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<Posts>> {
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful) {
                    val postList = response.body()!!
                    Log.d("Response", "postlist size : ${postList.size}")
                    postsList.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = PostAdapter(response.body()!!, this@PostsTab)
                    }}
                else {
                    Toast.makeText(
                        activity,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(activity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onItemClick(item: Posts, position: Int) {
        //Toast.makeText(activity, item.id.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(activity, DetailsActivity::class.java)
        intent.putExtra("id", item.id.toString())
        intent.putExtra("title", item.title)
        intent.putExtra("body", item.body)
        startActivity(intent)
    }
}

