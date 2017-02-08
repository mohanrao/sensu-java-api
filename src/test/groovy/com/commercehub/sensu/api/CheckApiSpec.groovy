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

import com.commercehub.sensu.api.exceptions.SensuNotFoundException

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class CheckApiSpec extends ApiSpec {

    def "listing checks"() {
        when:
        def checks = api.checks.sort { it.name }

        then:
        checks.collect { it.name } == ["check-cpu", "check-disk", "check-ram", "return-another-false", "return-false"]
        checks.collect { it.command } == ["/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-disk.rb",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-ram.rb -c 5 -w 10",
                                          "/usr/bin/false",
                                          "/usr/bin/false"]
        checks.every { it.handlers == ["default"] }
        checks.every { it.subscribers == ["all"] }
        checks.collect { it.interval } == [ 120, 120, 120, 8, 8]
    }

    def "getting a check by name returns a valid check object"() {
        when:
        def check = api.getCheck("check-cpu")

        then:
        check.name == "check-cpu"
        check.command == "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80"
        check.subscribers == ["all"]
        check.handlers == ["default"]
        check.interval == 120

        and:
        !check.subdue
    }

    def "Getting a check that has not been created throws a sensu not found exception"() {
        when:
        api.getCheck("missing-check")

        then:
        thrown(SensuNotFoundException)
    }

}
