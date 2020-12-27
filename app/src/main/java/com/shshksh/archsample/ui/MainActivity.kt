package com.shshksh.archsample.ui

import android.os.Bundle
import com.shshksh.archsample.databinding.ActivityMainBinding
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: Lazy<ActivityMainBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.get().lifecycleOwner = this
    }
}