package com.nordlocker.android_task.ui.todo_details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nordlocker.domain.interactors.GetTodoDetailsUseCase
import com.nordlocker.domain.interactors.UpdateTodoDetailsUseCase
import com.nordlocker.domain.models.Todo
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class TodoDetailsViewModel(
	todoId: Int,
	getTodoDetailsUseCase: GetTodoDetailsUseCase,
	private val updateTodoDetailsUseCase: UpdateTodoDetailsUseCase
) : ViewModel() {

	val todoDetailsFlow = getTodoDetailsUseCase(todoId).map {
		if (it != null) {
			TodoDetailsState.Success(it)
		} else {
			TodoDetailsState.Error(IllegalArgumentException(""))
		}
	}.catch {
		emit(TodoDetailsState.Error(it))
	}.stateIn(
		scope = viewModelScope,
		initialValue = TodoDetailsState.Loading,
		started = SharingStarted.WhileSubscribed()
	)

	fun changeTitle(title: String) {
		updateTodo { it.copy(title = title) }
	}

	fun switchCompleted(completed: Boolean) {
		updateTodo { it.copy(completed = completed) }
	}

	private fun updateTodo(todoChangeApplier: (Todo) -> Todo) {
		viewModelScope.launch {
			todoDetailsFlow.value.let {
				if (it is TodoDetailsState.Success) {
					updateTodoDetailsUseCase(todoChangeApplier(it.todo))
				} else {
					Log.w("TodoDetailsViewModel", "unsupported update operation for current state ")
				}
			}
		}
	}

}