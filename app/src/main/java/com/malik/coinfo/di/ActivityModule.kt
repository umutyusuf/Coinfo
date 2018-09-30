package com.malik.coinfo.di

import com.malik.coinfo.ui.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Module(includes = [ViewModelModule::class])
internal abstract class ActivityModule {
    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    @ActivityScope
    abstract fun provideMainActivityContributor(): HomeActivity

    @Scope
    @Retention
    internal annotation class ActivityScope
}