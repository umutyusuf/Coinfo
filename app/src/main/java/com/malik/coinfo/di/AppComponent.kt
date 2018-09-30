package com.malik.coinfo.di

import com.malik.coinfo.CoinfoApplication
import com.malik.domain.di.DataModule
import com.malik.domain.di.DomainModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityModule::class, DomainModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CoinfoApplication): Builder

        fun dataModule(dataModule: DataModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: CoinfoApplication)

}