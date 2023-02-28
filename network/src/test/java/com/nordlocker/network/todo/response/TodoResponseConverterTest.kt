package com.nordlocker.network.todo.response

import com.nordlocker.network.todo.response.TodoResponseConverter.convertToDomain
import org.junit.Test
import kotlin.random.Random


internal class TodoResponseConverterTest {

	@Test
	fun testConvertToDomain() {
		val testId = Random.nextInt()
		val testTitle = "Lorem ipsum"
		val testDueOn = "2023-02-28T00:00:00.000Z"
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = TodoResponseConverter.PENDING_STATUS,
			dueOn = testDueOn
		)

		val domain = todoResponse.convertToDomain()

		println(domain)

		assert(domain.id == testId)
		assert(domain.title == testTitle)
		assert(!domain.completed)
		assert(domain.createdAt == 0L)
		assert(domain.updatedAt == 0L)
		assert(domain.dueDate == 1677542400000L)
	}

	@Test(expected = IllegalArgumentException::class)
	fun testUnknownStatus() {
		val testId = Random.nextInt()
		val testTitle = "Lorem ipsum"
		val testDueOn = "2023-02-28T00:00:00.000Z"
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = "uncompleted",
			dueOn = testDueOn
		)

		todoResponse.convertToDomain()
	}

	@Test(expected = IllegalArgumentException::class)
	fun testNullId() {
		val testId = null
		val testTitle = "Lorem ipsum"
		val testDueOn = "2023-02-28T00:00:00.000Z"
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = TodoResponseConverter.PENDING_STATUS,
			dueOn = testDueOn
		)

		todoResponse.convertToDomain()
	}

	@Test(expected = IllegalArgumentException::class)
	fun testNullTitle() {
		val testId = Random.nextInt()
		val testTitle = null
		val testDueOn = "2023-02-28T00:00:00.000Z"
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = TodoResponseConverter.PENDING_STATUS,
			dueOn = testDueOn
		)

		todoResponse.convertToDomain()
	}

	@Test(expected = IllegalArgumentException::class)
	fun testNullDueOn() {
		val testId = Random.nextInt()
		val testTitle = "Lorem ipsum"
		val testDueOn = null
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = TodoResponseConverter.PENDING_STATUS,
			dueOn = testDueOn
		)

		todoResponse.convertToDomain()
	}

	@Test(expected = IllegalArgumentException::class)
	fun testWrongFormatDueOn() {
		val testId = Random.nextInt()
		val testTitle = "Lorem ipsum"
		val testDueOn = "2023-02-28"
		val todoResponse = TodoResponse(
			id = testId,
			title = testTitle,
			status = TodoResponseConverter.PENDING_STATUS,
			dueOn = testDueOn
		)

		todoResponse.convertToDomain()
	}

}