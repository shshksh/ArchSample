package com.shshksh.archsample.ui.user

import android.content.Context
import android.view.LayoutInflater
import com.shshksh.archsample.databinding.FragmentUserBinding
import com.shshksh.archsample.di.ActivityContext
import com.shshksh.archsample.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @Provides
    @FragmentScope
    fun provideBinding(@ActivityContext context: Context): FragmentUserBinding {
        return FragmentUserBinding.inflate(LayoutInflater.from(context))
    }

}