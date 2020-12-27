package com.shshksh.archsample.di

import com.shshksh.archsample.ui.MainActivity
import com.shshksh.archsample.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}