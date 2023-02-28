package com.nordlocker.domain.models

data class Todo(
    val id: Int? = null,
    val title: String? = null,
    val completed: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val dueDate: Long
)