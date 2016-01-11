package com.commercehub.sensu.api

import spock.lang.Specification

abstract class ApiSpec extends Specification {

    SensuApi api

    def setup() {
        def apiUrl = "http://192.168.30.3:4567"
        if (apiUrl) {
            def builder = SensuApiBuilder.builder()
            def username = 'sensu'
            def password = ''
            if (username && password) {
                builder.authentication(username, password)
            }
            api = builder.build(apiUrl)
        }
    }
}
