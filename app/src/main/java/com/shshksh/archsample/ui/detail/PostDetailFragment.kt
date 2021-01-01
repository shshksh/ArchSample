package com.shshksh.archsample.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shshksh.archsample.databinding.FragmentPostDetailBinding
import com.shshksh.archsample.di.AppViewModelFactory
import dagger.Lazy
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostDetailFragment : DaggerFragment() {

    @Inject
    lateinit var binding: FragmentPostDetailBinding

    @Inject
    lateinit var adapter: PostDetailAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    // TODO: 2021-01-01 inject viewmodefactory
//    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    lateinit var navController: Lazy<NavController>

    lateinit var viewModel: PostDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(PostDetailViewModel::class.java)

        savedInstanceState?.let {
            val args =
                PostDetailFragmentArgs.fromBundle(arguments ?: throw IllegalArgumentException())
            viewModel.load(args.post)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
            viewModel = this@PostDetailFragment.viewModel
        }
        viewModel.liveItems.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
        viewModel.userClickEvent.observe(viewLifecycleOwner) {
            // TODO: 2021-01-01 navigate setting 
//            navController.get().navigate(PostDetailFragmentDirections)
        }
    }
}