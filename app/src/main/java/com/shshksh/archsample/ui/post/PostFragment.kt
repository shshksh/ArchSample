package com.shshksh.archsample.ui.post

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shshksh.archsample.databinding.FragmentPostBinding
import com.shshksh.archsample.di.AppViewModelFactory
import dagger.Lazy
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostFragment : DaggerFragment() {

    @Inject
    lateinit var binding: FragmentPostBinding

    //     TODO: 2020-12-31 should implement AppViewModelFactory provider
//    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    lateinit var viewModel: PostViewModel

    @Inject
    lateinit var adapter: PostAdapter

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var navController: Lazy<NavController>

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            recyclerView.adapter = adapter
            recyclerView.layoutManager = layoutManager
            viewModel = this@PostFragment.viewModel
        }

        viewModel.livePosts.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }

        viewModel.postClickEvent.observe(viewLifecycleOwner) { postItem ->
            // TODO: 2020-12-31 post fragment navigation
//            navController.get().navigate()
        }
    }
}