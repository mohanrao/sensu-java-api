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

import com.commercehub.sensu.api.data.EventId
import com.commercehub.sensu.api.exceptions.SensuNotFoundException

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class EventApiSpec extends ApiSpec {

    def "listing events"() {
        when: "requesting events"
        def events = api.events.sort { a, b -> a.client.name <=> b.client.name ?: a.check.name <=> b.check.name }

        then: "events are returned"
        events.size() >= 3
        events.every { it.client.name == "sensu-client-server" }
        events.collect { it.check.name }.containsAll("return-false", "return-another-false")
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

    def "getting event by client is successful"() {
        when: "requesting an existing event"
        def event = api.getEvent("sensu-client-server", "check-disk")

        then: "the event is returned"
        event.client.name == "sensu-client-server"
        event.check.name == "check-disk"
        event.occurrences > 0
        event.check.status == 127
    }

    def "getting an event which does not exist throws a sensu not found exception"() {
        when: "requesting a non-existing event"
        api.getEvent("sensu-client-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by path"() {
        given: "an event exists for a given client and check"
        def originalEvent = api.getEvent("sensu-client-server", "return-false")

        when: "requesting resolution of an existing event by path"
        api.resolveEvent("sensu-client-server", "return-false")

        then:
        !api.events.contains(originalEvent.id)
    }

    def "resolving an event which does not exist, by path, throws a sensu not found exception"() {
        when: "requesting resolution of a non-existing event by path"
        api.resolveEvent("sensu-client-server", "missing-check")

        then:
        thrown(SensuNotFoundException)
    }

    def "resolving event by object"() {
        given: "an event exists for a given client and check"
        def originalEvent = api.getEvent("sensu-client-server", "return-another-false")

        when: "requesting resolution of an existing event by object"
        api.resolveEvent(new EventId("sensu-client-server", "return-another-false"))

        then:
        !api.events.contains(originalEvent.id)
    }

    def "resolving an event which does not exist, by object, throws a sensu not found exception"() {
        when: "requesting resolution of a non-existing event by object"
        api.resolveEvent(new EventId("sensu-client-server", "missing-check"))

        then:
        thrown(SensuNotFoundException)
    }
}
