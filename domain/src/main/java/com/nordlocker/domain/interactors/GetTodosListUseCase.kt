package com.nordlocker.domain.interactors

import com.nordlocker.domain.models.Todo
import com.nordlocker.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow


class GetTodosListUseCase(private val todoRepository: TodoRepository) {

	operator fun invoke(): Flow<List<Todo>> = todoRepository.observeTodos()

}