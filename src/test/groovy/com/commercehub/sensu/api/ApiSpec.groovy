package com.commercehub.sensu.api

import spock.lang.Specification

abstract class ApiSpec extends Specification {
    protected static final ENV_SENSU_URL = "http://192.168.30.3:4567"
    protected static final ENV_SENSU_USERNAME = "SENSU_API_USERNAME"
    protected static final ENV_SENSU_PASSWORD = "SENSU_API_PASSWORD"


    SensuApi api

    def setup() {
        //def apiUrl = System.getenv(ENV_SENSU_URL)
        def apiUrl = "http://192.168.30.3:4567"
        if (apiUrl) {
            def builder = SensuApiBuilder.builder()
            //def username = System.getenv(ENV_SENSU_USERNAME)
            def username = 'sensu'
            //def password = System.getenv(ENV_SENSU_PASSWORD)
            def password = ''
            if (username && password) {
                builder.authentication(username, password)
            }
            api = builder.build(apiUrl)
        }
    }
}
