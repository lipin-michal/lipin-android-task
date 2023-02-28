package com.nordlocker.network.todo

import android.util.Log
import com.nordlocker.domain.interfaces.TodoNetworkDataSource
import com.nordlocker.domain.models.Todo
import com.nordlocker.network.ApiClient
import com.nordlocker.network.todo.response.TodoListResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class TodoNetworkDataSourceImpl(
	private val client: ApiClient
) : TodoNetworkDataSource {

	private val json = Json { ignoreUnknownKeys = true }


	override suspend fun getAllTodos(): List<Todo> {
		val data = getResult<TodoListResponse>(
			onCall = { client.httpClient.get { url { encodedPath = "public-api/todos" } } }
		).data
		Log.d("TodoNetworkDataSource", data.toString())
		return data?.map { it.toDomain() } ?: emptyList()
	}

	private suspend inline fun <reified T : Any> getResult(
		crossinline onCall: suspend () -> HttpResponse,
	): T {
		val response = onCall()

		if (!response.status.isSuccess()) throw Exception("Error")
		else return json.decodeFromString(response.readText())
	}
}