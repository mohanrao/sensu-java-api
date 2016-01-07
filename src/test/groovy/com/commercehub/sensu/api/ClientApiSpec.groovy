package com.commercehub.sensu.api

import spock.lang.IgnoreIf

/**
 * Assumes clients created by https://github.com/arcus-io/docker-sensu.
 */
//@IgnoreIf({!env[ENV_SENSU_URL]})
class ClientApiSpec extends ApiSpec {
    def "listing clients"() {
        when:
        def clients = api.clients

        then:
        clients.size() == 2
        def client = clients[0]
        client.name == "sensu-client-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["all"]
        client.timestamp > 0
    }

    def "listing clients with paging"() {
        expect:
        api.getClients(1, 0).collect { it.name } == ["sensu-client-server"]
        api.getClients(1, 1).collect { it.name } == ["localhost"]
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
