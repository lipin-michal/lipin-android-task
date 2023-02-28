package com.nordlocker.network.todo.response

import com.nordlocker.domain.models.Todo
import java.text.SimpleDateFormat
import java.util.*

object TodoResponseConverter {

	private const val COMPLETED_STATUS = "completed"
	private const val PENDING_STATUS = "pending"

	private const val TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"


	fun TodoResponse.convertToDomain(): Todo {
		val completed = when (status) {
			COMPLETED_STATUS -> true
			PENDING_STATUS -> false
			else -> throw IllegalArgumentException("Couldn't resolve status: $status")
		}

		val creationDate = 0L
		val dueOnParsed = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).parse(dueOn!!)?.time ?: 0L

		return Todo(
			id = id,
			title = title,
			completed = completed,
			createdAt = creationDate,
			updatedAt = creationDate,
			dueDate = dueOnParsed
		)
	}

}