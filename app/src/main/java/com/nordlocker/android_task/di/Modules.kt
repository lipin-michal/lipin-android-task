package com.nordlocker.android_task.di

import com.nordlocker.android_task.ui.todo_details.TodoDetailsViewModel
import com.nordlocker.android_task.ui.todo_list.TodoListViewModel
import com.nordlocker.domain.interactors.GetTodosListUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
	factory { GetTodosListUseCase(get()) }
}

val appModule = module {

	viewModel { TodoListViewModel(get()) }
	viewModel { TodoDetailsViewModel() }

}