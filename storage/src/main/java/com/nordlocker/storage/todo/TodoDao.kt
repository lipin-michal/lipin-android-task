package com.nordlocker.storage.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

	companion object {
		const val TABLE_NAME = "todo"
	}

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun updateOrCreate(list: List<TodoEntity>)

	@Query("SELECT * FROM $TABLE_NAME")
	suspend fun getAll(): List<TodoEntity>

	@Query("SELECT * FROM $TABLE_NAME")
	fun observeTodos(): Flow<List<TodoEntity>>

	@Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
	suspend fun getTodo(id: Int): TodoEntity

	@Query("SELECT * FROM $TABLE_NAME WHERE id = :id")
	fun observeTodo(id: Int): Flow<TodoEntity?>

}