package com.rtr.moviesdemo.di

import android.app.Application
import android.content.Context
import com.rtr.moviesdemo.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { HomeViewModel(androidApplication()) }
}