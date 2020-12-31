package com.shshksh.archsample.ui.detail

import com.shshksh.archsample.data.entity.Post

class PostDetailPostItem(val post: Post) : PostDetailItem() {

    override fun getType(): Type {
        return Type.POST
    }

    fun getTitle(): String {
        return post.title
    }

    fun getBody(): String {
        return post.body
    }

}