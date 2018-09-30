package com.malik.coinfo.di

import com.malik.coinfo.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Scope

@Module
internal abstract class FragmentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @Scope
    @Retention
    internal annotation class FragmentScope
}