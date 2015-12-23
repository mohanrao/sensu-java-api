package com.commercehub.sensu.api;

import com.google.gson.JsonObject;
import feign.Headers;
import feign.RequestLine;

import javax.inject.Named;
import java.util.List;

/**
 * Client for the Sensu REST API.
 *
 * @see <a href="http://sensuapp.org/docs/0.13/api">The Sensu API</a>
 */
public interface SensuApi {
    /**
     * Returns the list of checks.
     *
     * @return the list of checks
     */
    @RequestLine("GET /checks")
    @Headers("Accept: application/json")
    List<Check> getChecks() throws SensuErrorException;

    /**
     * Returns a check.
     *
     * @param check the check name
     * @return a check
     */
    @RequestLine("GET /checks/{check}")
    @Headers("Accept: application/json")
    Check getCheck(@Named("check") String check) throws SensuNotFoundException, SensuErrorException;

    /**
     * Issues a check request.
     *
     * @param request the check request
     */
    @RequestLine("POST /request")
    void requestCheck(CheckRequest request) throws SensuMalformedDataException, SensuErrorException;

    /**
     * Returns the list of clients.
     *
     * @return the list of clients
     */
    @RequestLine("GET /clients")
    @Headers("Accept: application/json")
    List<Client> getClients() throws SensuErrorException;

    /**
     * Returns the list of clients.
     *
     * @param limit  the number of stashes to return
     * @param offset the number of stashes to offset before returning items
     * @return the list of clients
     */
    @RequestLine("GET /clients?limit={limit}&offset={offset}")
    @Headers("Accept: application/json")
    List<Client> getClients(@Named("limit") int limit, @Named("offset") int offset) throws SensuErrorException;

    /**
     * Returns a client.
     *
     * @param client the client name
     * @return a client
     */
    @RequestLine("GET /clients/{client}")
    @Headers("Accept: application/json")
    Client getClient(@Named("client") String client) throws SensuNotFoundException, SensuErrorException;

    /**
     * Removes a client, resolving its current events (delayed action).
     *
     * @param client the client name
     */
    @RequestLine("DELETE /clients/{name}")
    void deleteClient(@Named("client") String client) throws SensuNotFoundException, SensuErrorException;

    /**
     * Returns the client history.
     *
     * @param client the client name
     * @return the client history
     */
    @RequestLine("GET /clients/{client}/history")
    List<ClientCheckHistory> getClientHistory(@Named("client") String client) throws SensuErrorException;

    /**
     * Returns the list of current events.
     *
     * @return the list of current events
     */
    @RequestLine("GET /events")
    @Headers("Accept: application/json")
    List<Event> getEvents() throws SensuErrorException;

    /**
     * Returns the list of current events for a client.
     *
     * @param client the client for which to find events
     * @return the list of current events for a client
     */
    @RequestLine("GET /events/{client}")
    @Headers("Accept: application/json")
    List<Event> getEvents(@Named("client") String client) throws SensuErrorException;

    /**
     * Returns an event.
     *
     * @param client the client for the event
     * @param check the check for the event
     * @return an event
     */
    @RequestLine("GET /events/{client}/{check}")
    @Headers("Accept: application/json")
    Event getEvent(@Named("client") String client, @Named("check") String check) throws SensuNotFoundException, SensuErrorException;

    /**
     * Resolves an event (delayed action).
     *
     * @param client the client for the event
     * @param check the check for the event
     */
    @RequestLine("DELETE /events/{client}/{check}")
    void resolveEvent(@Named("client") String client, @Named("check") String check) throws SensuNotFoundException, SensuErrorException;

    /**
     * Resolves an event (delayed action).
     *
     * @param eventId the event to resolve
     */
    @RequestLine("POST /resolve")
    @Headers("Content-Type: application/json")
    void resolveEvent(EventId eventId) throws SensuNotFoundException, SensuMalformedDataException, SensuErrorException;

    /**
     * Returns a list of stash paths.
     *
     * @return a list of stash paths
     */
    @RequestLine("GET /stashes")
    @Headers("Accept: application/json")
    List<StashPath> getStashes() throws SensuErrorException;

    /**
     * Returns a list of stash paths.
     *
     * @param limit  the number of stashes to return
     * @param offset the number of stashes to offset before returning items
     * @return a list of stash paths
     */
    @RequestLine("GET /stashes?limit={limit}&offset={offset}")
    @Headers("Accept: application/json")
    List<StashPath> getStashes(@Named("limit") int limit, @Named("offset") int offset) throws SensuErrorException;

    /**
     * Creates a stash.
     *
     * @param stashPath information about the desired stash
     */
    @RequestLine("POST /stashes")
    @Headers("Content-Type: application/json")
    void createStash(StashPath stashPath) throws SensuMalformedDataException, SensuErrorException;

    /**
     * Creates a stash.  If you want the stash to expire, use {@link #createStash(StashPath)} instead.
     *
     * @param path the path for the stash
     * @param stash the stash to create
     */
    @RequestLine("POST /stashes/{path}")
    @Headers("Content-Type: application/json")
    void createStash(@Named("path") String path, JsonObject stash) throws SensuMalformedDataException, SensuErrorException;

    /**
     * Returns the stash with the specified path.
     *
     * @param path the path for the stash
     * @return the stash with the specified path
     */
    @RequestLine("GET /stashes/{path}")
    @Headers("Accept: application/json")
    JsonObject getStash(@Named("path") String path) throws SensuNotFoundException, SensuErrorException;

    /**
     * Deletes the stash with the specified path.
     *
     * @param path the path for the stash
     */
    @RequestLine("DELETE /stashes/{path}")
    void deleteStash(@Named("path") String path) throws SensuNotFoundException, SensuErrorException;
}
