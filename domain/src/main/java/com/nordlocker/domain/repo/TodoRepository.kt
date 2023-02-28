package com.nordlocker.domain.repo

import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {

	suspend fun refreshTodos()

	suspend fun observeTodos(): Flow<List<Todo>>

	fun observeTodo(id: Int): Flow<Todo?>

}