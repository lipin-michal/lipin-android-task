package com.nordlocker.android_task.di

import com.nordlocker.android_task.ui.todo_details.TodoDetailsViewModel
import com.nordlocker.android_task.ui.todo_list.TodoListViewModel
import com.nordlocker.domain.interactors.GetTodoDetailsUseCase
import com.nordlocker.domain.interactors.GetTodosListUseCase
import com.nordlocker.domain.interactors.RefreshTodosUseCase
import com.nordlocker.domain.repo.TodoRepository
import com.nordlocker.domain.repo.TodoRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val domainModule = module {
	single<TodoRepository> { TodoRepositoryImpl(get(), get()) }
	factory { RefreshTodosUseCase(get()) }
	factory { GetTodosListUseCase(get()) }
	factory { GetTodoDetailsUseCase(get()) }
}

val appModule = module {

	viewModel { TodoListViewModel(get(), get()) }
	viewModel { args -> TodoDetailsViewModel(args.get(), get()) }

}