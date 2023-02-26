package com.nordlocker.domain.interfaces

import com.nordlocker.domain.models.Todo

interface TodoNetworkDataSource {

	suspend fun getAllTodos(): List<Todo>

}