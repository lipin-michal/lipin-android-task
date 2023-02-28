package com.nordlocker.network.todo.response

import com.nordlocker.domain.models.Todo
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object TodoResponseConverter {

	const val COMPLETED_STATUS = "completed"
	const val PENDING_STATUS = "pending"

	private const val TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"

	fun TodoResponse.convertToDomain(): Todo {
		if (id == null) {
			throw IllegalArgumentException("Couldn't resolve id")
		}

		if (title == null) {
			throw IllegalArgumentException("Couldn't resolve title")
		}

		if (dueOn == null) {
			throw IllegalArgumentException("Couldn't resolve dueOn")
		}

		val completed = when (status) {
			COMPLETED_STATUS -> true
			PENDING_STATUS -> false
			else -> throw IllegalArgumentException("Couldn't resolve status: $status")
		}

		val creationDate = 0L
		try {
			val dueOnParsed = SimpleDateFormat(TIME_FORMAT, Locale.getDefault()).apply {
				timeZone = TimeZone.getTimeZone("UTC")
			}.parse(dueOn)?.time ?: 0L

			return Todo(
				id = id,
				title = title,
				completed = completed,
				createdAt = creationDate,
				updatedAt = creationDate,
				dueDate = dueOnParsed
			)
		} catch (e: ParseException) {
			throw IllegalArgumentException("Couldn't parse dueOn date")
		}
	}

}