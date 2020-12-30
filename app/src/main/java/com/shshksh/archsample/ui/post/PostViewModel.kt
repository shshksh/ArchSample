package com.shshksh.archsample.ui.post

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class PostViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {

    private val loading = MutableLiveData(true)

    fun loadPosts() {
        
    }

}