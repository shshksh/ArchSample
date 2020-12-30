package com.shshksh.archsample.ui

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.shshksh.archsample.R
import com.shshksh.archsample.databinding.ActivityMainBinding
import com.shshksh.archsample.di.ActivityScope
import com.shshksh.archsample.di.FragmentScope
import com.shshksh.archsample.ui.post.PostFragment
import com.shshksh.archsample.ui.post.PostModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainModule {

    companion object {
        @Provides
        @ActivityScope
        fun provideBinding(activity: MainActivity?): ActivityMainBinding =
            DataBindingUtil.setContentView(activity!!, R.layout.activity_main)

        @Provides
        @ActivityScope
        fun provideContext(activity: MainActivity): Context = activity
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun getPostFragment(): PostFragment

}