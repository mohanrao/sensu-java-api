package com.commercehub.sensu.api

import spock.lang.IgnoreIf

/**
 * Assumes checks/events created by https://github.com/arcus-io/docker-sensu.
 */
@IgnoreIf({!env[ENV_SENSU_URL]})
class EventApiSpec extends ApiSpec {
    def "listing events"() {
        when: "requesting events"
        def events = api.events.sort { a, b -> a.client <=> b.client ?: a.check <=> b.check }

        then: "events are returned"
        events.size() == 5
        events.every { it.client == "sensu-server" }
        events.collect { it.check.name } == ["sensu-api", "sensu-dashboard", "sensu-rabbitmq-beam", "sensu-rabbitmq-epmd", "sensu-redis"]
        events.collect { it.check.subscribers } != null
        events.collect { it.check.interval } != null
        events.every { it.occurrences > 0 }
        events.every { it.output.trim() == "sh: 1: /etc/sensu/plugins/check-procs.rb: not found" }
        events.every { it.status == 127 }
    }

    def "listing events by client"() {
        expect:
        api.getEvents("sensu-server").size() == 5
        api.getEvents("other-server").empty
    }

    def "getting event by client"() {
        when: "requesting an existing event"
        def event = api.getEvent("sensu-server", "sensu-api")

        then: "the event is returned"
        event.client == "sensu-server"
        event.check == "sensu-api"
        event.occurrences > 0
        event.output.trim() == "sh: 1: /etc/sensu/plugins/check-procs.rb: not found"
        event.status == 127

        when: "requesting a non-existing event"
        api.getEvent("sensu-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by path"() {
        when: "requesting resolution of an existing event by path"
        api.resolveEvent("sensu-server", "sensu-rabbitmq-beam")

        then:
        !api.events.find { it.check == "sensu-rabbitmq-beam" }

        when: "requesting resolution of a non-existing event by path"
        api.resolveEvent("sensu-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by object"() {
        when: "requesting resolution of an existing event by object"
        api.resolveEvent(new EventId("sensu-server", "sensu-rabbitmq-epmd"))

        then:
        !api.events.find { it.check == "sensu-rabbitmq-epmd" }

        when: "requesting resolution of a non-existing event by object"
        api.resolveEvent(new EventId("sensu-server", "missing-check"))

        then:
        thrown(SensuNotFoundException)
    }
}
