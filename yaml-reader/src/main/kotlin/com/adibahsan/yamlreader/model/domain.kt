package com.adibahsan.yamlreader.model

data class YamlRequestBody(
    val version: String,
    val applicationId: String,
    val sourceAddress: String,
    val message: String,
    val requestId: String,
    val encoding: String
)

data class YamlResponseBody(
    val version: String,
    val applicationId: String,
    val password: String,
    val message: String,
    val destinationAddresses: List<String>,
    val sourceAddress: String,
    val deliveryStatusRequest: String,
    val encoding: String,
    val binaryHeader: String
)
