package com.example.assessmenttask.ui.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessmenttask.data.model.Posts
import com.example.assessmenttask.database.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PostViewModel @Inject constructor(
    repository: AppRepository
): ViewModel(), LifecycleObserver {

    private val postsFlow = MutableStateFlow<List<Posts>>(emptyList())
    val post: Flow<List<Posts>> = postsFlow

    init {
        viewModelScope.launch {
            val posts = repository.getPosts()
            postsFlow.value = posts
        }
    }
}