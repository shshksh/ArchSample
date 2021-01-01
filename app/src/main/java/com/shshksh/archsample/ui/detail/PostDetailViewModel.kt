package com.shshksh.archsample.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.shshksh.archsample.data.CommentService
import com.shshksh.archsample.data.UserService
import com.shshksh.archsample.data.entity.Post
import com.shshksh.archsample.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import javax.inject.Inject
import javax.inject.Named

class PostDetailViewModel @Inject constructor(
    application: Application,
    val userService: UserService,
    val commentService: CommentService,
    @Named("errorEvent") val errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application), PostDetailUserItem.EventListener {

    init {
        Timber.d("PostDetailViewModel created")
    }

    val liveItems = MutableLiveData<List<PostDetailItem>>()
    private val compositeDisposable = CompositeDisposable()

    val loading = MutableLiveData<Boolean>()

    val userClickEvent = SingleLiveEvent<Long>()

    fun load(post: Post) {
        compositeDisposable.add(Single.zip(userService.getUser(post.userId),
            Single.just(post),
            commentService.getComments(post.id),
            { user, p, comments ->
                val list: MutableList<PostDetailItem> = ArrayList()
                list.add(PostDetailUserItem(user, this))
                list.add(PostDetailPostItem(p))
                for (comment in comments) {
                    list.add(PostDetailCommentItem(comment))
                }
                list
            })
            .retry(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { loading.postValue(false) }
            .subscribe(liveItems::setValue, errorEvent::setValue)
        )
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared")
        this.compositeDisposable.dispose()
    }

    override fun onUserClick(userId: Long) {
        userClickEvent.value = userId
    }
}
