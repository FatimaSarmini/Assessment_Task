package com.example.assessmenttask.ui.view
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmenttask.R
import kotlinx.coroutines.flow.collect
import com.example.assessmenttask.adapter.CommentsAdapter
import com.example.assessmenttask.databinding.ActivityDetailsBinding
import com.example.assessmenttask.ui.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: DetailsViewModel by viewModels()

    private val commentAdapter = CommentsAdapter()

    private var id = 0
    private var titlePost = ""
    private var bodyPost = ""
    private var isFavorite = false

    companion object {

        private const val KEY_ID = "key_id"
        private const val KEY_TITLE = "key_title"
        private const val KEY_BODY = "KEY_BODY"
        private const val KEY_FAV = "KEY_FAV"


        fun startActivity(context: Context, id: Int, title: String, body: String, favorite: Boolean): Intent {
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra(KEY_ID, id)
            intent.putExtra(KEY_TITLE, title)
            intent.putExtra(KEY_BODY, body)
            intent.putExtra(KEY_FAV, favorite)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView()
        getIntentData()
        setupView()
        setupRecyclerView()
        loadComments()
        setupListener()
    }

    private fun getIntentData() {
        id = intent.getIntExtra(KEY_ID,0)
        titlePost = intent.getStringExtra(KEY_TITLE) ?: ""
        bodyPost = intent.getStringExtra(KEY_BODY) ?: ""
        isFavorite = intent.getBooleanExtra(KEY_FAV,false)
    }

    private fun setupView() = with (binding) {
        title.text = titlePost
        body.text = bodyPost
    }

    private fun bindingView() {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun  setupRecyclerView() = with(binding) {
        commentsList.apply {
            adapter = commentAdapter
            layoutManager = LinearLayoutManager(this@DetailsActivity)
            setHasFixedSize(true)
        }
    }

    private fun loadComments() {
        lifecycle.coroutineScope.launch {
            viewModel.comment.collect { comments ->
                commentAdapter.submitList(comments)
            }
        }
    }

    private fun setupListener() = with(binding) {
        favBtn.setOnClickListener {
            if(isFavorite){
                favBtn.setImageResource(R.drawable.ic_baseline_favorite_white)
            } else {
                favBtn.setImageResource(R.drawable.ic_baseline_favorite_red)
            }
            viewModel.updateFavorite(id)
        }

        backBtn.setOnClickListener {
            this@DetailsActivity.finish()
        }
    }

}

