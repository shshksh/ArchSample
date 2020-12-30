package com.shshksh.archsample.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.shshksh.archsample.databinding.FragmentPostBinding
import com.shshksh.archsample.di.AppViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var binding: FragmentPostBinding

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    lateinit var viewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(PostViewModel::class.java)
        savedInstanceState?.let {
            viewModel.loadPosts()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}