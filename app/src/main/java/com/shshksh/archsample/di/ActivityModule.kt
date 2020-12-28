package com.shshksh.archsample.di

import com.shshksh.archsample.ui.MainActivity
import com.shshksh.archsample.ui.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity

}

// 액티비티 서브 컴포넌트들의 의존성을 명시하는 모듈이라고 할 수 있지 않을까?
// 기존의 경우 모듈 어노테이션에서 명시한 서브 컴포넌트를 @ContributesAndroidInjector 를 사용하는 것으로 변경하였다.
// 덕분에 서브 컴포넌트의 빌더를 제공하는 함수를 작성할 필요가 없어졌다.
