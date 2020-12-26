package com.shshksh.archsample.data.entity

data class Comment(
    private val postId: Long,
    private val id: Long,
    private val name: String,
    private val email: String,
    private val body: String,
)