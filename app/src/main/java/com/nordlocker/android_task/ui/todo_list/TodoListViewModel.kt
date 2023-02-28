package com.nordlocker.android_task.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nordlocker.domain.interactors.GetTodosListUseCase
import com.nordlocker.domain.interactors.RefreshTodosUseCase
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class TodoListViewModel(
	private val refreshTodosUseCase: RefreshTodosUseCase,
	private val getTodosListUseCase: GetTodosListUseCase
) : ViewModel() {

	private val _todoListStateFlow: MutableStateFlow<List<Todo>> = MutableStateFlow(emptyList())
	val todoListStateFlow: StateFlow<List<Todo>> = _todoListStateFlow.asStateFlow()

	init {
		refreshTodos()
		observeTodos()
	}

	private fun refreshTodos() {
		viewModelScope.launch {
			refreshTodosUseCase()
		}
	}

	private fun observeTodos() {
		viewModelScope.launch {
			_todoListStateFlow.emitAll(getTodosListUseCase())
		}
	}

}