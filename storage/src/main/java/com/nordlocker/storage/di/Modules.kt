package com.nordlocker.storage.di

import com.nordlocker.domain.interfaces.TodoStorageDataSource
import com.nordlocker.storage.DatabaseCreator
import com.nordlocker.storage.todo.TodoStorageServiceImpl
import org.koin.dsl.module

val storageModule = module {
    single { DatabaseCreator.create(get()) }
    single<TodoStorageDataSource> { TodoStorageServiceImpl(database = get()) }
}