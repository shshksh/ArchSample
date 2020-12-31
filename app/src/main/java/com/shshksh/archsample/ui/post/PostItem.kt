package com.shshksh.archsample.ui.post

import com.shshksh.archsample.data.entity.Post

class PostItem(val post: Post, val eventListener: EventListener) {

    fun getTitle(): String {
        return post.title
    }

    interface EventListener {
        fun onPostClick(postItem: PostItem)
    }

}