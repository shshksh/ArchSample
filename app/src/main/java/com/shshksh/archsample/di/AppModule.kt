package com.shshksh.archsample.di

import android.app.Application
import android.content.Context
import com.shshksh.archsample.App
import com.shshksh.archsample.util.SingleLiveEvent
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        ViewModelModule::class,
        RetrofitModule::class
    ]
)
class AppModule {

    @Provides
    @Singleton
    fun provideApp(app: App): Application = app

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(app: App): Context = app

    @Singleton
    @Provides
    @Named("errorEvent")
    fun provideErrorEvent(): SingleLiveEvent<Throwable> = SingleLiveEvent()

    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

}

// includes: 모듈의 상속. 컴포넌트에서 AppModule을 참조하면 ViewModelModule에서 제공하는 의존성도 포함한다.