/*
 * Copyright (C) 2016 Commerce Technologies, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.commercehub.sensu.api

import spock.lang.Specification

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
abstract class ApiSpec extends Specification {

    SensuApi api

    def setup() {
        def apiUrl = "http://192.168.40.4:4567"
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
