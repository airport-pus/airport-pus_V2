package com.airportpus_v2.common.exception

import org.springframework.http.HttpStatus

open class AirportPusV2Exception(
    val status: HttpStatus,
    val errorCode: String,
    message: String? = null
) : RuntimeException(message)
