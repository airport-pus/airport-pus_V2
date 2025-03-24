package com.airportpus_v2.common.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.bind.ConstructorBinding

@ConfigurationProperties(prefix = "spring.api")
data class ApiProperties @ConstructorBinding constructor(
    val serviceKey: String,
    val parkingBaseUrl: String,
    val congestionBaseUrl: String,
    val apronBaseUrl: String,
    val holidayBaseUrl: String,
)
