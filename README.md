# Sensu-Java-Api
[ ![Build Status](https://travis-ci.org/commercehub-oss/sensu-java-api.svg?branch=master) ](https://travis-ci.org/commercehub-oss/sensu-java-api)

`sensu-java-api` is a Java API for the [Sensu monitoring framework](http://sensuapp.org/).  Specifically, it provides Java bindings for the [Sensu API](https://sensuapp.org/docs/0.26/api/) provided by Sensu itself.  It currently uses [Feign](https://github.com/Netflix/feign) as the HTTP client.
Previous versions of sensu-java-api supported Sensu Api version 0.13 (https://github.com/sensu/sensu-docs/tree/master/legacy/0.13) while the current version supports version 0.26 (https://sensuapp.org/docs/0.26/api/)


# What does it do?

It provides bindings for the following functionality:

* Reading information about checks
* Reading information about clients
* Reading information about events
* Reading information about stashes
* Issuing check requests
* Deleting clients
* Resolving events
* Creating/updating/deleting stashes

It does not yet have bindings for:
* Dealing with [aggregates](https://sensuapp.org/docs/0.26/api/aggregates-api.html)
* Checking Sensu's [health and info](https://sensuapp.org/docs/0.26/api/health-and-info-api.html)
* Creating and updating [clients and client data](https://sensuapp.org/docs/0.26/api/clients-api.html#clients-post)
* Accessing [the silenced api](https://sensuapp.org/docs/0.26/api/silenced-api.html)


The following functionality is not provided by the Sensu API, and thus cannot be included (unless it's first added to Sensu):

* Creating checks
* Creating events

The following functionality is deprecated in Sensu API, and should be addressed as a future upgrade to sensu-java-api

* Using the [stashes endpoint instead of silence endpoint](https://sensuapp.org/docs/0.26/reference/silencing.html#appendix-deprecated-stash-based-silencing)

# Where do I get it?

[ ![Download](https://api.bintray.com/packages/commercehub-oss/main/sensu-java-api/images/download.svg) ](https://bintray.com/commercehub-oss/main/sensu-java-api/_latestVersion)

Binaries are published to JCenter.  To use the library from [Gradle](https://www.gradle.org/), use something like this (substitute latest version):

```groovy
repositories {
    jcenter()
}
dependencies {
    compile "com.commercehub.sensu:sensu-java-api:VERSION"
}
```

# How do I use it?

Examples below are in [Groovy](http://groovy-lang.org/).  First, build an instance of `SensuApi` using `SensuApiBuilder`:

```groovy
def api = SensuApiBuilder.builder()
    .authentication(username, password)
    .build(apiUrl)
```

Then, use its methods to interact with the Sensu API:

```groovy
println "Current checks: ${api.checks}"
println "Current clients: ${api.clients}"
println "Current events: ${api.events}"
println "Current stashes: ${api.stashes}"
```

# Testing

Start up the accompanying Vagrant images:

```
vagrant up
```

This creates a machine with sensu api and client installed locally. Three checks are installed for testing purposes.

Run the standard gradle wrapper test command  to run unit tests for the sensu-java-api.

```
gradle test
```
 
Results are visible from the command line, as well as in the local build/test-results directory.

Between test runs, allow at least two minutes for checks to re-set their statuses, as some tests are updating the status.

# Compatibility

Sensu-Java-API currently supports Java 8.
