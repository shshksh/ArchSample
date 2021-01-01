package com.shshksh.archsample.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.shshksh.archsample.databinding.FragmentUserBinding
import com.shshksh.archsample.di.AppViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class UserFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory

    @Inject
    lateinit var binding: FragmentUserBinding

    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, viewModelFactory).get(UserViewModel::class.java)

        if (savedInstanceState == null) {
            val args = UserFragmentArgs.fromBundle(arguments ?: throw IllegalArgumentException())
            viewModel.loadUser(args.userId)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}