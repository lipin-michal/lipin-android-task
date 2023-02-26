package com.nordlocker.android_task.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nordlocker.domain.interactors.GetTodosListUseCase
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class TodoListViewModel(
	private val getTodosListUseCase: GetTodosListUseCase
) : ViewModel() {

	private val _todoListStateFlow: MutableStateFlow<List<Todo>> = MutableStateFlow(emptyList())
	val todoListStateFlow: StateFlow<List<Todo>> = _todoListStateFlow.asStateFlow()

	init {
		loadTodos()
	}

	private fun loadTodos() {
		viewModelScope.launch {
			_todoListStateFlow.emitAll(getTodosListUseCase())
		}
	}

}