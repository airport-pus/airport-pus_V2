package com.airportpus_v2.common.exception

import java.time.LocalDateTime

data class ErrorResponse(
    val status: Int,
    val errorCode: String,
    val message: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun from(exception: AirportPusV2Exception): ErrorResponse {
            return ErrorResponse(
                status = exception.status.value(),
                errorCode = exception.errorCode,
                message = exception.message.orEmpty(),
            )
        }

        fun from(status: Int, errorCode: String, message: String): ErrorResponse {
            return ErrorResponse(
                status = status,
                errorCode = errorCode,
                message = message
            )
        }
    }
}
