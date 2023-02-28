package com.nordlocker.domain.interfaces

import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.Flow

interface TodoStorageDataSource {

	val todosFlow: Flow<List<Todo>>

	suspend fun updateOrCreate(list: List<Todo>)

	suspend fun getAll(): List<Todo>

	suspend fun getTodo(id: Int): Todo

//	suspend fun observeTodo(id: Int): Flow<Todo>

}