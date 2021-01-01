package com.shshksh.archsample.ui

import android.content.Context
import androidx.databinding.DataBindingUtil
import com.shshksh.archsample.R
import com.shshksh.archsample.databinding.ActivityMainBinding
import com.shshksh.archsample.di.ActivityContext
import com.shshksh.archsample.di.ActivityScope
import com.shshksh.archsample.di.FragmentScope
import com.shshksh.archsample.ui.detail.PostDetailFragment
import com.shshksh.archsample.ui.detail.PostDetailModule
import com.shshksh.archsample.ui.post.PostFragment
import com.shshksh.archsample.ui.post.PostModule
import com.shshksh.archsample.ui.user.UserFragment
import com.shshksh.archsample.ui.user.UserModule
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
        @ActivityContext
        fun provideContext(activity: MainActivity): Context = activity
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun getPostFragment(): PostFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [PostDetailModule::class])
    abstract fun getPostDetailFragment(): PostDetailFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun getUserFragment(): UserFragment

}