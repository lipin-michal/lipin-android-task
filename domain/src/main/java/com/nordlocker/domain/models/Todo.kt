package com.nordlocker.domain.models

data class Todo(
	val id: Int,
	val title: String,
	val completed: Boolean,
	val createdAt: Long,
	val updatedAt: Long,
	val dueDate: Long
)