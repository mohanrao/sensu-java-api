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

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class CheckApiSpec extends ApiSpec {
    def "listing checks"() {
        when:
        def checks = api.checks.sort { it.name }

        then:
        checks.collect { it.name } == ["check-cpu", "check-disk", "check-ram"]
        checks.collect { it.command } == ["/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-disk.rb",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-ram.rb -c 5 -w 10"]
        checks.every { it.handler }
        checks.every { it.subscribers == ["all"] }
        checks.every { it.interval == 120 }
    }

    def "getting check by name"() {
        when:
        def check = api.getCheck("check-cpu")

        then:
        check.name == "check-cpu"
        check.command == "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80"
        check.subscribers == ["all"]
        check.interval == 120

        when:
        api.getCheck("missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "issuing a check request"() {
        when:
        api.requestCheck(new CheckRequest("check-ram", "all"))

        then:
        noExceptionThrown()

        when:
        api.requestCheck(new CheckRequest("bad-client"))

        then:
        thrown(SensuNotFoundException)
    }
}
