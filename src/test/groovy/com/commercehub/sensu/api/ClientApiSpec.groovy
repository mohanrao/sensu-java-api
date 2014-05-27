package com.commercehub.sensu.api

import spock.lang.IgnoreIf

/**
 * Assumes clients created by https://github.com/arcus-io/docker-sensu.
 */
@IgnoreIf({!env[ENV_SENSU_URL]})
class ClientApiSpec extends ApiSpec {
    def "listing clients"() {
        when:
        def clients = api.clients

        then:
        clients.size() == 1
        def client = clients[0]
        client.name == "sensu-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["default", "sensu"]
        client.timestamp > 0
    }

    def "listing clients with paging"() {
        expect:
        api.getClients(1, 0).collect { it.name } == ["sensu-server"]
        api.getClients(1, 1).empty
    }

    def "getting client by path"() {
        when: "requesting an existing client"
        def client = api.getClient("sensu-server")

        then:
        client.name == "sensu-server"
        client.address == "127.0.0.1"
        client.subscriptions == ["default", "sensu"]
        client.timestamp > 0

        when: "requesting a non-existing client"
        api.getClient("non-client")

        then:
        thrown(SensuNotFoundException)
    }

    def "getting client history"() {
        when:
        def clientHistory = api.getClientHistory("sensu-server").sort { it.check }

        then:
        clientHistory.collect { it.check } == ["keepalive", "sensu-api", "sensu-dashboard", "sensu-rabbitmq-beam", "sensu-rabbitmq-epmd", "sensu-redis"]
        // history isn't particularly reliable for testing; most fields don't have assertions
    }

    // no coverage of deleting clients due to inability to re-create
}
