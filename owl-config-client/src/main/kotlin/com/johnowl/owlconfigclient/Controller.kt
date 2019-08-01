package com.johnowl.owlconfigclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.core.env.EnumerablePropertySource
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.Environment

@RestController
class Controller(
        @Value("\${my-awesome-configuration}")
        val config: String,

        @Value("\${feature.my_feature_one.enabled}")
        val enabled: Boolean,

        val env: Environment
) {

    @GetMapping("/config")
    fun readConfig() = config

    @GetMapping("/feature-one-is-enabled")
    fun featureIsEnabled() = enabled

    @GetMapping("/all-toggles")
    fun getAllToggles(): Map<String, String> {

        val regex = """^feature\.[a-zA-Z0-9_-]+\.enabled$""".toRegex()

        val properties = mutableMapOf<String, String>()
        if (env is ConfigurableEnvironment) {
            for (propertySource in (env as ConfigurableEnvironment).propertySources) {
                if (propertySource is EnumerablePropertySource<*>) {
                    for (key in propertySource.propertyNames) {
                        if (regex.matches(key)) {
                            properties[key] = propertySource.getProperty(key).toString()
                        }
                    }
                }
            }
        }

        return properties
    }
}