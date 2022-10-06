package com.example.arhitectureexamples.core.di

import com.example.arhitectureexamples.core.repo.DataRepository
import com.example.arhitectureexamples.core.usecase.GetSomeData
import com.example.arhitectureexamples.mvp.MVPPresenter
import com.example.arhitectureexamples.mvp.base.Contract
import com.example.arhitectureexamples.mvvm.MVVMViewModel
import com.example.arhitectureexamples.mvi.MVIViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mainModules = module {
    factory<Contract.Presenter> { (view: Contract.View) -> MVPPresenter(view, get()) }
    factoryOf(::GetSomeData)
    singleOf(::DataRepository)
    viewModelOf(::MVVMViewModel)
    viewModelOf(::MVIViewModel)
}

val appModules = listOf(
    mainModules
)
