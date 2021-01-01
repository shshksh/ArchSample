package com.shshksh.archsample.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shshksh.archsample.databinding.FragmentPostDetailBinding
import com.shshksh.archsample.di.ApplicationContext
import com.shshksh.archsample.di.FragmentScope
import dagger.Module
import dagger.Provides

@Module
class PostDetailModule {

    @Provides
    @FragmentScope
    fun provideBinding(@ApplicationContext context: Context): FragmentPostDetailBinding {
        return FragmentPostDetailBinding.inflate(LayoutInflater.from(context), null, false)
    }

    @Provides
    @FragmentScope
    fun provideLayoutManager(@ApplicationContext context: Context): LinearLayoutManager {
        return object : LinearLayoutManager(context) {
            override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
                return RecyclerView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
    }

    @Provides
    @FragmentScope
    fun provideNavController(fragment: PostDetailFragment): NavController {
        return NavHostFragment.findNavController(fragment)
    }

}