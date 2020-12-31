package com.shshksh.archsample.ui.post

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shshksh.archsample.data.PostService
import com.shshksh.archsample.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class PostViewModel @Inject constructor(
    application: Application,
    val postService: PostService,
    @Named("errorEvent") val errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application), PostItem.EventListener {

    init {
        Timber.d("PostViewModel created")
    }

    val livePosts = MutableLiveData<List<PostItem>>()
    private val compositeDisposable = CompositeDisposable()
    val loading = MutableLiveData(true)
    val postClickEvent = SingleLiveEvent<PostItem>()

    fun loadPosts() {
        compositeDisposable.add(
            postService.getPosts()
                .flatMapObservable { Observable.fromIterable(it) }
                .map { post -> PostItem(post, this) }
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess { loading.postValue(false) }
                .subscribe(livePosts::setValue, errorEvent::setValue)
        )
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
        compositeDisposable.dispose()
    }

    override fun onPostClick(postItem: PostItem) {
        postClickEvent.value = postItem
    }

}