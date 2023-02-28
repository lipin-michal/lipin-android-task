package com.nordlocker.android_task.ui.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nordlocker.domain.interactors.GetTodosListUseCase
import com.nordlocker.domain.interactors.RefreshTodosUseCase
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TodoListViewModel(
	private val refreshTodosUseCase: RefreshTodosUseCase,
	private val getTodosListUseCase: GetTodosListUseCase
) : ViewModel() {

	private val _todoListStateFlow: MutableStateFlow<List<Todo>> = MutableStateFlow(emptyList())
	val todoListStateFlow: StateFlow<List<Todo>> = _todoListStateFlow.asStateFlow()

	private var todoSortType: TodoSortType? = null

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

	fun switchTodoSortType() {
		todoSortType = when (todoSortType) {
			TodoSortType.RecentlyUpdated -> TodoSortType.NotCompleted
			TodoSortType.NotCompleted -> TodoSortType.RecentlyUpdated
			else -> TodoSortType.NotCompleted
		}
		viewModelScope.launch {
			_todoListStateFlow.update {
				it.toList().sortedWith(todoSortType!!.comparator)
			}
		}
	}

}