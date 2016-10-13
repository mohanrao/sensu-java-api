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
class ClientApiSpec extends ApiSpec {
    def "listing clients"() {
        when:
        def clients = api.clients

        then:
        clients.size() == 1
        def client = clients[0]
        client.name == "sensu-client-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["all"]
        client.timestamp > 0
    }

    def "listing clients with paging"() {
        expect:
        api.getClients(1, 0).collect { it.name } == ["sensu-client-server"]
        api.getClients(1, 1).empty
    }

    def "getting client by path"() {
        when: "requesting an existing client"
        def client = api.getClient("sensu-client-server")

        then:
        client.name == "sensu-client-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["all"]
        client.timestamp > 0

        when: "requesting a non-existing client"
        api.getClient("non-client")

        then:
        thrown(SensuNotFoundException)
    }

    def "getting client history"() {
        when:
        def clientHistory = api.getClientHistory("sensu-client-server").sort { it.check }

        then:
        clientHistory.collect { it.check } == ["check-cpu", "check-disk", "check-ram", "keepalive"]
        // history isn't particularly reliable for testing; most fields don't have assertions
    }

    // no coverage of deleting clients due to inability to re-create
}
