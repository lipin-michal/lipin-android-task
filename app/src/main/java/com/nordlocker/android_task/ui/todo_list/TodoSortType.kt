package com.nordlocker.android_task.ui.todo_list

import com.nordlocker.domain.models.Todo

sealed class TodoSortType(val comparator: Comparator<Todo>) {
	object NotCompleted :
		TodoSortType(Comparator { p0, p1 -> p0.completed.compareTo(p1.completed) })

	object RecentlyUpdated :
		TodoSortType(Comparator { p0, p1 -> p1.updatedAt.compareTo(p0.updatedAt) })
}
