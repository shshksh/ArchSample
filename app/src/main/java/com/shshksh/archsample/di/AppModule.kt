package com.shshksh.archsample.di

import android.app.Application
import com.shshksh.archsample.App
import com.shshksh.archsample.util.SingleLiveEvent
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApp(app: App): Application = app

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(app: App) = app

    @Singleton
    @Provides
    @Named("errorEvent")
    fun provideErrorEvent(): SingleLiveEvent<Throwable> = SingleLiveEvent()
}