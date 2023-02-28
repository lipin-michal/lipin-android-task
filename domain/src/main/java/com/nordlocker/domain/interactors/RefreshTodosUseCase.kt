package com.nordlocker.domain.interactors

import com.nordlocker.domain.repo.TodoRepository

class RefreshTodosUseCase(private val todoRepository: TodoRepository) {

	suspend operator fun invoke() = todoRepository.refreshTodos()

}