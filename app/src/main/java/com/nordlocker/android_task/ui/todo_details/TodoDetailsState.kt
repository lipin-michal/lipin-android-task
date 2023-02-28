package com.nordlocker.android_task.ui.todo_details

import com.nordlocker.domain.models.Todo

sealed interface TodoDetailsState {

	object Loading : TodoDetailsState

	data class Success(val todo: Todo) : TodoDetailsState

	data class Error(val throwable: Throwable) : TodoDetailsState

}