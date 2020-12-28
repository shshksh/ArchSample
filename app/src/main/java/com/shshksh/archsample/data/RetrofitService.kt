package com.shshksh.archsample.data

import com.shshksh.archsample.data.entity.Comment
import com.shshksh.archsample.data.entity.Post
import com.shshksh.archsample.data.entity.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {
    @GET("/posts")
    fun getPosts(): Single<List<Post>>
}

interface CommentService {
    @GET("/comments")
    fun getComments(@Query("postId") id: Long): Single<List<Comment>>
}

interface UserService {
    @GET("/users/{userId}")
    fun getUser(@Path("userId") userId: Long): Single<User>
}