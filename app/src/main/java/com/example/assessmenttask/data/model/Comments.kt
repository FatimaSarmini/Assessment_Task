package com.example.assessmenttask.data.model


data class Comments (
    var id: Int,
    var postId: Int,
    var email: String?,
    var name: String?,
    var body: String?,
)