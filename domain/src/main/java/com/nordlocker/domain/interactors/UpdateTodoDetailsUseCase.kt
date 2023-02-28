package com.nordlocker.domain.interactors

import com.nordlocker.domain.models.Todo
import com.nordlocker.domain.repo.TodoRepository


class UpdateTodoDetailsUseCase(private val todoRepository: TodoRepository) {

	suspend operator fun invoke(todo: Todo) {
		todoRepository.update(todo)
	}

}