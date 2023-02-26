package com.nordlocker.network.todo.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodoListResponse(
	@SerialName("code")
    val code: Int? = null,
	@SerialName("meta")
    val meta: MetaResponse? = null,
	@SerialName("data")
    val data: List<TodoResponse>? = null
)