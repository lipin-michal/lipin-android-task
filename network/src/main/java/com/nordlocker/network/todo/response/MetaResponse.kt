package com.nordlocker.network.todo.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MetaResponse(
    @SerialName("pagination")
    val pagination: PaginationResponse
) {

    @Serializable
    data class PaginationResponse(
        @SerialName("total")
        val total: Int? = null,
        @SerialName("pages")
        val pages: Int? = null,
        @SerialName("page")
        val page: Int? = null,
        @SerialName("limit")
        val limit: Int? = null
    )
}