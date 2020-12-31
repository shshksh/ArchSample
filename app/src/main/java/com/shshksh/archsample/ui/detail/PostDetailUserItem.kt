package com.shshksh.archsample.ui.detail

import com.shshksh.archsample.data.entity.User

class PostDetailUserItem(val user: User, val eventListener: EventListener) : PostDetailItem() {

    override fun getType(): Type {
        return Type.USER
    }

    fun getName(): String {
        return user.name
    }

    fun getUserId(): Long {
        return user.id
    }

    interface EventListener {
        fun onUserClick(userId: Long)
    }

}