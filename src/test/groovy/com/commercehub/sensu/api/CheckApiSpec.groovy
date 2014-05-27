package com.commercehub.sensu.api

import spock.lang.IgnoreIf

/**
 * Assumes checks created by https://github.com/arcus-io/docker-sensu.
 */
@IgnoreIf({!env[ENV_SENSU_URL]})
class CheckApiSpec extends ApiSpec {
    def "listing checks"() {
        when:
        def checks = api.checks.sort { it.name }

        then:
        checks.collect { it.name } == ["sensu-api", "sensu-dashboard", "sensu-rabbitmq-beam", "sensu-rabbitmq-epmd", "sensu-redis"]
        checks.collect { it.command } == ["/etc/sensu/plugins/check-procs.rb -p sensu-api -C 1 -w 4 -c 5", "/etc/sensu/plugins/check-procs.rb -p sensu-dashboard -C 1 -w 1 -c 1", "/etc/sensu/plugins/check-procs.rb -p beam -C 1 -w 4 -c 5", "/etc/sensu/plugins/check-procs.rb -p epmd -C 1 -w 1 -c 1", "/etc/sensu/plugins/check-procs.rb -p redis-server -C 1 -w 4 -c 5"]
        checks.every { it.subscribers == ["sensu"] }
        checks.every { it.interval == 60 }
    }

    def "getting check by name"() {
        when:
        def check = api.getCheck("sensu-api")

        then:
        check.name == "sensu-api"
        check.command == "/etc/sensu/plugins/check-procs.rb -p sensu-api -C 1 -w 4 -c 5"
        check.subscribers == ["sensu"]
        check.interval == 60

        when:
        api.getCheck("missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "issuing a check request"() {
        when:
        api.requestCheck(new CheckRequest("sensu-api", "sensu"))

        then:
        noExceptionThrown()

        when:
        api.requestCheck(new CheckRequest("bad-client"))

        then:
        thrown(SensuNotFoundException)
    }
}
