package com.nordlocker.domain.interactors

import com.nordlocker.domain.interfaces.TodoNetworkDataSource
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class GetTodosListUseCase(
	private val  todoNetworkDataSource: TodoNetworkDataSource,
	private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

	operator fun invoke(): Flow<List<Todo>> = flow {
		emit(emptyList())
		emit(todoNetworkDataSource.getAllTodos())
	}.flowOn(dispatcher)

}