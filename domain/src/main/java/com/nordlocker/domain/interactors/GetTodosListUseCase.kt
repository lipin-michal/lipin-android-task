package com.nordlocker.domain.interactors

import com.nordlocker.domain.models.Todo
import com.nordlocker.domain.repo.TodoRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn


class GetTodosListUseCase(
	private val todoRepository: TodoRepository,
	private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

	suspend operator fun invoke(): Flow<List<Todo>> = todoRepository.observeTodos().flowOn(dispatcher)

}