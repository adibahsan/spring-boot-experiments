package com.adibahsan.yamlreader.controller

import com.adibahsan.yamlreader.model.YamlRequestBody
import com.adibahsan.yamlreader.model.YamlResponseBody
import com.adibahsan.yamlreader.util.YamlReader
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class YamlReaderController(
    private val yamlReader: YamlReader
) {

    @PostMapping(
        "/receiver",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun post(@RequestBody requestBody: YamlRequestBody): Mono<YamlResponseBody> {
        println("yaml reader data ${yamlReader.getDataMap()}")

        val responseBody = YamlResponseBody(
            version = "1.0",
            applicationId = "APP_999999",
            password = "password",
            message = "Hello",
            destinationAddresses = listOf(requestBody.sourceAddress),
            sourceAddress = "77000",
            deliveryStatusRequest = "1",
            encoding = "245",
            binaryHeader = "526574697265206170706c69636174696f6e20616e642072656c6561736520524b7320696620666f756e642065787069726564"
        )
        return Mono.just(responseBody)
    }

}
