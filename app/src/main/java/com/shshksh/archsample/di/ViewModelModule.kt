package com.shshksh.archsample.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shshksh.archsample.ui.detail.PostDetailViewModel
import com.shshksh.archsample.ui.post.PostViewModel
import com.shshksh.archsample.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(viewModel: PostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel::class)
    abstract fun bindsPostDetailViewModel(viewModel: PostDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindsUserViewModel(viewModel: UserViewModel): ViewModel

}