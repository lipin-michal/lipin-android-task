package com.nordlocker.domain.repo

import com.nordlocker.domain.interfaces.TodoNetworkDataSource
import com.nordlocker.domain.interfaces.TodoStorageDataSource
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.*
import java.io.IOException

class TodoRepositoryImpl(
	private val todoStorageDataSource: TodoStorageDataSource,
	private val todoNetworkDataSource: TodoNetworkDataSource,
) : TodoRepository {

	private fun getNetworkTodos(): Flow<List<Todo>> = flow {
		emit(todoNetworkDataSource.getAllTodos())
	}.retryWhen { cause, _ ->
		cause is IOException
	}

	override suspend fun refreshTodos() {
		todoStorageDataSource.updateOrCreate(getNetworkTodos().first())
	}

	override suspend fun observeTodos(): Flow<List<Todo>> {
		return todoStorageDataSource.todosFlow
	}

	override suspend fun getTodoDetails(id: Int): Todo {
		return todoStorageDataSource.getTodo(id)
	}
}