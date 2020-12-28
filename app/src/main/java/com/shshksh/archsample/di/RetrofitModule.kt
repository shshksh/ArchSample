package com.shshksh.archsample.di

import com.shshksh.archsample.data.CommentService
import com.shshksh.archsample.data.PostService
import com.shshksh.archsample.data.UserService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class RetrofitModule {

    @Provides
    @Reusable
    fun providePostService(retrofit: Retrofit): PostService =
        retrofit.create(PostService::class.java)

    @Provides
    @Reusable
    fun provideCommentService(retrofit: Retrofit): CommentService =
        retrofit.create(CommentService::class.java)

    @Provides
    @Reusable
    fun provideUserService(retrofit: Retrofit): UserService =
        retrofit.create(UserService::class.java)

}