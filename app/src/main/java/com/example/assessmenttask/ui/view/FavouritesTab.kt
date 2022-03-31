package com.example.assessmenttask.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assessmenttask.R
import kotlinx.coroutines.flow.collect
import com.example.assessmenttask.adapter.PostAdapter
import com.example.assessmenttask.data.model.Posts
import com.example.assessmenttask.databinding.FragmentFavouritesTabBinding
import com.example.assessmenttask.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouritesTab : Fragment(R.layout.fragment_favourites_tab)  {

    private var currentBinding: FragmentFavouritesTabBinding? = null
    private val binding get() = currentBinding!!

    private val viewModel: FavoriteViewModel by viewModels()

    private lateinit var postAdapter: PostAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindView(view)
        postAdapter = PostAdapter(onItemClick = { post ->
            onPostClick(post)
        })
        setupRecyclerView()
        loadPosts()
    }

    private fun bindView(view: View) {
        currentBinding = FragmentFavouritesTabBinding.bind(view)
    }

    private fun setupRecyclerView() = with(binding) {
        postsList.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }
    }

    private fun loadPosts() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.post.collect { posts ->
                postAdapter.submitList(posts)
            }
        }

    }

    private fun onPostClick(item: Posts) {
        startActivity(DetailsActivity.startActivity(requireContext(),item.id,item.title,item.body,item.isFavorite))
    }

}