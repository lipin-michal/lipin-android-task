package com.nordlocker.domain.interactors

import com.nordlocker.domain.models.Todo
import com.nordlocker.domain.repo.TodoRepository
import kotlinx.coroutines.flow.Flow


class GetTodoDetailsUseCase(private val todoRepository: TodoRepository) {

	operator fun invoke(id: Int): Flow<Todo?> = todoRepository.observeTodo(id)

}