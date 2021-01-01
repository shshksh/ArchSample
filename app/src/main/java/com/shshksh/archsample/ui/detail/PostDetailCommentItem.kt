package com.shshksh.archsample.ui.detail

import com.shshksh.archsample.data.entity.Comment

class PostDetailCommentItem(private val comment: Comment): PostDetailItem() {

    override fun getType(): Type {
        return Type.COMMENT
    }

    fun getName(): String {
        return comment.name
    }

    fun getBody(): String {
        return comment.body
    }

}