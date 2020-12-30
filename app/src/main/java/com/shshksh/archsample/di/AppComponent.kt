package com.shshksh.archsample.di

import com.shshksh.archsample.App
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App> {

    }

}

// AndroidSupportInjectionModule: 안드로이드 프레임워크 관련 클래스의 의존성 주입을 위임할 AndroidInjector<*>의 팩토리를 멀티바인딩으로 관리하는 모듈.
// AndroidInjector<App>: inject 메서드를 포함하고 있다.
// AndroidInjector.Factory<App>: create 메서드를 포함하고 있다.