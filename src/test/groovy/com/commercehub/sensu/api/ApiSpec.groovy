package com.commercehub.sensu.api

import spock.lang.Specification

abstract class ApiSpec extends Specification {
    protected static final ENV_SENSU_URL = "SENSU_API_URL"
    protected static final ENV_SENSU_USERNAME = "SENSU_API_USERNAME"
    protected static final ENV_SENSU_PASSWORD = "SENSU_API_PASSWORD"

    SensuApi api

    def setup() {
        def apiUrl = System.getenv(ENV_SENSU_URL)
        if (apiUrl) {
            def builder = SensuApiBuilder.builder()
            def username = System.getenv(ENV_SENSU_USERNAME)
            def password = System.getenv(ENV_SENSU_PASSWORD)
            if (username && password) {
                builder.authentication(username, password)
            }
            api = builder.build(apiUrl)
        }
    }
}
