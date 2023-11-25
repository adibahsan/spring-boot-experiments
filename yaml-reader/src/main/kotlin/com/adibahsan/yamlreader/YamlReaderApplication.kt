package com.adibahsan.yamlreader

import com.adibahsan.yamlreader.util.YamlReader
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class YamlReaderApplication{
	@Bean
	fun init(yamlReader: YamlReader): CommandLineRunner {
		return CommandLineRunner {
			val dataMap = yamlReader.getDataMap()
			println("Data read from YAML file: $dataMap")
		}
	}

}

fun main(args: Array<String>) {
	runApplication<YamlReaderApplication>(*args)
}
