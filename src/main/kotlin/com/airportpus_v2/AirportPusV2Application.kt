package com.airportpus_v2

import com.airportpus_v2.common.config.ApiProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(ApiProperties::class)
class AirportPusV2Application

fun main(args: Array<String>) {
    runApplication<AirportPusV2Application>(*args)
}
