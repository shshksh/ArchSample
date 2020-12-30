package com.shshksh.archsample.ui.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shshksh.archsample.databinding.FragmentPostBinding
import com.shshksh.archsample.di.ApplicationContext
import com.shshksh.archsample.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class PostModule {

    @Provides
    @FragmentScope
    fun provideBinding(@ApplicationContext context: Context): FragmentPostBinding {
        return FragmentPostBinding.inflate(LayoutInflater.from(context), null, false)
    }

    @Provides
    @FragmentScope
    fun provideLinearLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return object : LinearLayoutManager(context) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }

}