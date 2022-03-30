package com.example.assessmenttask.ui.view


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmenttask.R
import com.example.assessmenttask.adapter.CommentsAdapter
import com.example.assessmenttask.data.api.ApiService
import com.example.assessmenttask.data.api.RetrofitBuilder
import com.example.assessmenttask.data.model.Comments
import com.example.assessmenttask.di.AppModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.assessmenttask.ui.viewmodel.DetailsViewModel


class DetailsActivity : AppCompatActivity() {

    private val viewModel: DetailsViewModel = TODO()

    private var isFavorite = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        val id = getIntent().getStringExtra("id")
        val title = findViewById<TextView>(R.id.title)
        val body = findViewById<TextView>(R.id.body)
        val backButton = findViewById<ImageView>(R.id.back_btn)
        val favButton = findViewById<ImageView>(R.id.fav_btn)

        val x = getIntent().getStringExtra("title")
        val y =getIntent().getStringExtra("body")
        title.text = getIntent().getStringExtra("title")
        body.text = getIntent().getStringExtra("body")


        //handle back button click
        backButton.setOnClickListener {
            //start activity intent
            startActivity(Intent(this, MainActivity::class.java))
        }


        val commentsList = findViewById<RecyclerView?>(R.id.commentsList)
        //loading comments for this post
        loadComments(commentsList, Integer.parseInt(id))

        //handle fav button click
       favButton.setOnClickListener{

           if(isFavorite){
               favButton.setImageResource(R.drawable.ic_baseline_favorite_white)
           } else {
               favButton.setImageResource(R.drawable.ic_baseline_favorite_red)
           }
           viewModel.updateFavorite(Integer.parseInt(id))
       }

     }




    private fun loadComments(commentsList: RecyclerView, postId: Int) {
        //initiate the service
        val destinationService = RetrofitBuilder.buildService(ApiService::class.java)
        val requestCall = destinationService.getCommentList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<Comments>> {
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful) {
                    val commentList = response.body()!!
                    Log.d("Response", "commentList size : ${commentList.size}")
                    commentsList.apply {
                        layoutManager = LinearLayoutManager(this@DetailsActivity)
                        adapter = CommentsAdapter(response.body()!!.filter { it.postId == postId })
                    }
                } else {
                    Toast.makeText(
                        this@DetailsActivity,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Toast.makeText(this@DetailsActivity, "Something went wrong $t", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }


}

