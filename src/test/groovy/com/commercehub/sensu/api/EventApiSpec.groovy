package com.commercehub.sensu.api

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class EventApiSpec extends ApiSpec {
    def "listing events"() {
        when: "requesting events"
        def events = api.events.sort { a, b -> a.client.name <=> b.client.name ?: a.check.name <=> b.check.name }

        then: "events are returned"
        events.size() > 1
        events.every { it.client.name == "sensu-client-server" }
        events.collect { it.check.name } == ["check-cpu", "check-disk", "check-ram"]
        events.collect { it.check.subscribers } != null
        events.collect { it.check.interval } != null
        events.every { it.occurrences > 0 }
        events.every { it.check.status == 127 }
    }

    def "listing events by client"() {
        expect:
        api.getEvents("sensu-client-server").size() > 1
        api.getEvents("other-server").empty
    }

    def "getting event by client"() {
        when: "requesting an existing event"
        def event = api.getEvent("sensu-client-server", "check-disk")

        then: "the event is returned"
        event.client.name == "sensu-client-server"
        event.check.name == "check-disk"
        event.occurrences > 0
        event.check.status == 127

        when: "requesting a non-existing event"
        api.getEvent("sensu-client-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by path"() {
        when: "requesting resolution of an existing event by path"
        api.resolveEvent("sensu-client-server", "check-ram")

        then:
        !api.events.find { it.check.name == "check-ram" }

        when: "requesting resolution of a non-existing event by path"
        api.resolveEvent("sensu-client-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by object"() {
        when: "requesting resolution of an existing event by object"
        api.resolveEvent(new EventId("sensu-client-server", "check-cpu"))

        then:
        !api.events.find { it.check.name == "check-cpu" }

        when: "requesting resolution of a non-existing event by object"
        api.resolveEvent(new EventId("sensu-client-server", "missing-check"))

        then:
        thrown(SensuNotFoundException)
    }
}
