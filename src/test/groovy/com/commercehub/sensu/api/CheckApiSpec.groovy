package com.commercehub.sensu.api

import spock.lang.IgnoreIf

/**
 * Assumes checks created by https://github.com/arcus-io/docker-sensu.
 */
//@IgnoreIf({!env[ENV_SENSU_URL]})
class CheckApiSpec extends ApiSpec {
    def "listing checks"() {
        when:
        def checks = api.checks.sort { it.name }

        then:
        checks.collect { it.name } == ["check-cpu", "check-disk", "check-ram"]
        checks.collect { it.command } == ["/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-disk.rb",
                                          "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-ram.rb -c 5 -w 10"]
        checks.every { it.subscribers == ["all"] }
        checks.collect { it.interval == [120,300,300] }
    }

    def "getting check by name"() {
        when:
        def check = api.getCheck("check-cpu")

        then:
        check.name == "check-cpu"
        check.command == "/usr/bin/ruby1.9.3 /etc/sensu/plugins/check-cpu.rb -c 90 -w 80"
        check.subscribers == ["all"]
        check.interval == 120
        //check.handler == ["default"]
        //check.occurrences == 2

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
