package com.shshksh.archsample.di

import com.shshksh.archsample.data.CommentService
import com.shshksh.archsample.data.PostService
import com.shshksh.archsample.data.UserService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

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