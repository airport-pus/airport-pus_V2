package com.airportpus_v2.common.logging

import org.slf4j.LoggerFactory

object LoggingUtils {
    private val logger = LoggerFactory.getLogger(LoggingUtils::class.java)

    fun logWarning(exception: Throwable) {
        val message = exception.message?.takeIf { it.isNotBlank() } ?: ""
        logger.warn("$message\n \t $exception")
    }

    fun logError(exception: Throwable) {
        val message = exception.message?.takeIf { it.isNotBlank() } ?: ""
        logger.error("$message\n \t $exception")
    }
}
