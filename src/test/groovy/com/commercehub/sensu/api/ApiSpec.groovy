package com.commercehub.sensu.api

import spock.lang.Specification

abstract class ApiSpec extends Specification {
    protected static final ENV_SENSU_URL = "SENSU_API_URL"

    SensuApi api

    def setup() {
        def apiUrl = System.getenv(ENV_SENSU_URL)
        if (apiUrl) {
            api = SensuApiBuilder.build(apiUrl)
        }
    }
}
