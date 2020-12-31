package com.shshksh.archsample.ui.detail

abstract class PostDetailItem {

    abstract fun getType(): Type

    enum class Type {
        USER, POST, COMMENT
    }

}