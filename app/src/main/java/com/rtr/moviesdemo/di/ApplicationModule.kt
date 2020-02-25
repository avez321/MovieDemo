package com.rtr.moviesdemo.di

import android.app.Application
import com.rtr.moviesdemo.repository.RepositoryImp
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val applicationModule = module {
    single<RepositoryImp> {  RepositoryImp(get()) }
}