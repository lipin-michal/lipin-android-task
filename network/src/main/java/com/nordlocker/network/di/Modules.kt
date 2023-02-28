package com.nordlocker.network.di

import com.nordlocker.domain.interfaces.TodoNetworkDataSource
import com.nordlocker.network.ApiClient
import com.nordlocker.network.todo.TodoNetworkDataSourceImpl
import org.koin.dsl.module

val networkModule = module {
	single { ApiClient() }
	single<TodoNetworkDataSource> { TodoNetworkDataSourceImpl(client = get()) }
}