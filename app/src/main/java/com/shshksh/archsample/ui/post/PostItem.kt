package com.shshksh.archsample.ui.post

import com.shshksh.archsample.data.entity.Post

class PostItem(val post: Post) {

    fun getTitle(): String {
        return post.title
    }

}