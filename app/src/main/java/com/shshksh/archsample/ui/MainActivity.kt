package com.shshksh.archsample.ui

import android.os.Bundle
import android.widget.Toast
import com.shshksh.archsample.databinding.ActivityMainBinding
import com.shshksh.archsample.util.SingleLiveEvent
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var binding: Lazy<ActivityMainBinding>

    @Inject
    @Named("errorEvent")
    lateinit var errorEvent: SingleLiveEvent<Throwable>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.get().lifecycleOwner = this
        errorEvent.observe(this, this::showErrorToast)
        Timber.d("MainActivity onCreate")
    }

    private fun showErrorToast(throwable: Throwable) {
        throwable.printStackTrace()
        showToast(throwable.message)
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}