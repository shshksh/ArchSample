package com.shshksh.archsample.ui

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.shshksh.archsample.R
import com.shshksh.archsample.databinding.ActivityMainBinding
import com.shshksh.archsample.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
object MainModule {
    @Provides
    @ActivityScope
    fun provideBinding(activity: MainActivity?): ActivityMainBinding =
        DataBindingUtil.setContentView(activity!!, R.layout.activity_main)

    @Provides
    @ActivityScope
    fun provideContext(activity: MainActivity): Context = activity
}