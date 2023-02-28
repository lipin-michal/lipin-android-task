package com.nordlocker.storage.todo

import android.util.Log
import com.nordlocker.domain.interfaces.TodoStorageDataSource
import com.nordlocker.domain.models.Todo
import com.nordlocker.storage.todo.TodoEntity.Companion.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoStorageServiceImpl(database: TodoDatabase) : TodoStorageDataSource {

	private val dao = database.todoDao()

	override val todosFlow: Flow<List<Todo>> = dao.observeTodos().map { todosList ->
		Log.d("TodoStorageService", todosList.toString())
		todosList.map { it.toDomain() }
	}

	override suspend fun updateOrCreate(list: List<Todo>) {
		dao.updateOrCreate(list.map { it.toEntity() })
	}

	override suspend fun getAll(): List<Todo> =
		dao.getAll().map { it.toDomain() }

	override suspend fun getTodo(id: Int): Todo =
		dao.getTodo(id).toDomain()

}