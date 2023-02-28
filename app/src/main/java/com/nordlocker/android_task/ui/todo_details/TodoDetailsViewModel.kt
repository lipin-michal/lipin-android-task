package com.nordlocker.android_task.ui.todo_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nordlocker.domain.interactors.GetTodoDetailsUseCase
import kotlinx.coroutines.flow.*

class TodoDetailsViewModel(
	todoId: Int,
	getTodoDetailsUseCase: GetTodoDetailsUseCase
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


}