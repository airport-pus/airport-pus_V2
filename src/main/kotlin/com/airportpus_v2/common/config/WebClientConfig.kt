package com.airportpus_v2.common.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.xml.Jaxb2XmlDecoder
import org.springframework.http.codec.xml.Jaxb2XmlEncoder
import org.springframework.web.reactive.function.client.ExchangeStrategies
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.util.DefaultUriBuilderFactory

@Configuration
class WebClientConfig(private val apiProperties: ApiProperties) {

    @Bean
    @Qualifier("parkingWebClient")
    fun parkingWebClient(): WebClient {
        val factory = DefaultUriBuilderFactory(apiProperties.parkingBaseUrl)
        factory.encodingMode = DefaultUriBuilderFactory.EncodingMode.VALUES_ONLY
        return WebClient.builder()
            .uriBuilderFactory(factory)
            .exchangeStrategies(
                ExchangeStrategies.builder()
                    .codecs { clientCodecConfigurer ->
                        clientCodecConfigurer.defaultCodecs().jaxb2Decoder(Jaxb2XmlDecoder())
                        clientCodecConfigurer.defaultCodecs().jaxb2Encoder(Jaxb2XmlEncoder())
                    }
                    .build()
            )
            .build()
    }
}
