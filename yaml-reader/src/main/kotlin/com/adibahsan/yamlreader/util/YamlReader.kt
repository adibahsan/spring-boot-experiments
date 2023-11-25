package com.adibahsan.yamlreader.util

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import org.yaml.snakeyaml.Yaml
import java.io.InputStream

@Component
@PropertySource("classpath:message.yml")
class YamlReader(
    @Value("classpath:message.yml")
    private val yamlResource: Resource
) {
    fun getDataMap(): Map<String, String> {
        val yaml = Yaml()
        val inputStream: InputStream = yamlResource.inputStream
        @Suppress("UNCHECKED_CAST")
        return yaml.load(inputStream) as Map<String, String>
    }
}
