package com.nordlocker.storage.todo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nordlocker.domain.models.Todo
import java.time.LocalDateTime

@Entity(tableName = TodoDao.TABLE_NAME)
class TodoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val completed: Boolean,
    val createdAt: Long,
    val updatedAt: Long,
    val dueDate: Long
) {

    companion object {
        fun Todo.toEntity() =
            TodoEntity(
                id = id ?: 0,
                title = title ?: "",
                completed = completed,
                createdAt = createdAt,
                updatedAt = updatedAt,
                dueDate = dueDate
            )
    }

    fun toDomain() = Todo(
        id = id,
        title = title,
        completed = completed,
        createdAt = createdAt,
        updatedAt = updatedAt,
        dueDate = dueDate
    )
}