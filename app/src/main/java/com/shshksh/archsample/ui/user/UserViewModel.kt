package com.shshksh.archsample.ui.user

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.shshksh.archsample.data.UserService
import com.shshksh.archsample.data.entity.User
import com.shshksh.archsample.util.SingleLiveEvent
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class UserViewModel @Inject constructor(
    application: Application,
    private val userService: UserService,
    @Named("errorEvent") private val errorEvent: SingleLiveEvent<Throwable>
) : AndroidViewModel(application) {

    init {
        Timber.d("UserViewModel created")
    }

    private val compositeDisposable = CompositeDisposable()
    private val liveItem = MutableLiveData<User>()

    val name = Transformations.map(liveItem) { it.name }
    val email = Transformations.map(liveItem) { it.email }
    val homepage = Transformations.map(liveItem) { it.website }
    val phone = Transformations.map(liveItem) { it.phone }
    val location = Transformations.map(liveItem) { it.address.toString() }

    val loading = MutableLiveData<Boolean>()

    fun loadUser(userId: Long) {
        compositeDisposable.add(userService.getUser(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { loading.postValue(false) }
            .subscribe(liveItem::setValue, errorEvent::setValue)
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}