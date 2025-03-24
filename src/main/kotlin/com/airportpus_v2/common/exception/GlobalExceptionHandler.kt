package com.airportpus_v2.common.exception

import com.airportpus_v2.common.logging.LoggingUtils
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(Throwable::class)
    fun handleException(exception: Throwable): ResponseEntity<ErrorResponse> {
        return when (exception) {
            is AirportPusV2Exception -> {
                LoggingUtils.logWarning(exception)
                ResponseEntity.status(exception.status).body(ErrorResponse.from(exception))
            }
            is MethodArgumentTypeMismatchException -> {
                LoggingUtils.logWarning(exception)
                ResponseEntity.status(400).body(ErrorResponse.from(400, "TYPE_MISMATCH", "파라미터 타입이 일치하지 않습니다."))
            }
            is IllegalArgumentException -> {
                LoggingUtils.logWarning(exception)
                ResponseEntity.status(400).body(ErrorResponse.from(400, "INVALID_ARGUMENT", "잘못된 값이 들어왔습니다."))
            }
            is NullPointerException -> {
                LoggingUtils.logWarning(exception)
                ResponseEntity.status(400).body(ErrorResponse.from(400, "NULL_VALUE", "필수 값이 누락되었습니다."))
            }
            else -> {
                LoggingUtils.logError(exception)
                ResponseEntity.status(500).body(ErrorResponse.from(500, "SERVER_UNKNOWN", "서버에서 알 수 없는 에러가 발생했습니다."))
            }
        }
    }
}
