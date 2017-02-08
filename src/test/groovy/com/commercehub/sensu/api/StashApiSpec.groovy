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

import com.commercehub.sensu.api.exceptions.SensuNotFoundException
import com.commercehub.sensu.api.data.StashPath
import com.google.gson.JsonObject
import static com.commercehub.sensu.api.data.StashPath.NEVER

/**
 * Assumes checks/events created by included Vagrant image and Chef recipes. Please see README for instructions.
 */
class StashApiSpec extends ApiSpec {
    private static final String PATH1 = "silence/node1"
    private static final String PATH2 = "silence/node2/check1"
    private static final String PATH3 = "silence/node3"

    def setup() {
        deleteAllStashes()
    }

    def "listing empty stashes"() {
        given: "there are no stashes"
        // already ensured by setup()

        when: "the stashes are requested"
        def stashes = api.stashes

        then: "an empty list is returned"
        stashes.empty
    }

    def "listing non-empty stashes"() {
        given: "there are stashes"
        def expectedStashes = [newStash(PATH1, [key1: "value1"]), newStash(PATH2, [key2: "value2"], 10)]
        expectedStashes.each { api.createStash(it) }

        when: "the stashes are requested"
        def actualStashes = api.stashes

        then: "the stashes are returned"
        actualStashes.sort { it.path } == expectedStashes
    }

    def "listing stashes with paging, where the paging is greater than the number of stashes, is successful"() {
        given: "there are stashes"
        def stash1 = newStash(PATH1, [key1: "value1"])
        def stash2 = newStash(PATH2, [:], 10)
        def stash3 = newStash(PATH3)
        [stash1, stash2, stash3].each { api.createStash(it) }

        when: "requesting stashes with limit greater than available"
        def page1_5 = api.getStashes(5, 0)

        then: "all available stashes are returned"
        page1_5.sort { it.path } == [stash1, stash2, stash3]

        when: "requesting stashes with smaller page size"
        def page1_2 = api.getStashes(2, 0)
        def page2_2 = api.getStashes(2, 2)
        //TODO: Investigate options other than feign to handle validation on requests
        //def page3_2 = api.getStashes(2, 4)

        then: "results are broken into pages until no more available"
        page1_2.size() == 2
        page2_2.size() == 1
        //page3_2.empty
        (page1_2 + page2_2).sort { it.path } == [stash1, stash2, stash3]
    }

    def "creating stashes by object"() {
        when: "creating stashes by object"
        def stash1 = newStash(PATH1, [key1: "value1"])
        def stash2 = newStash(PATH2, [key2: "value2"], 10)
        [stash1, stash2].each { api.createStash(it) }
        def stashes = api.stashes.sort { it.path }

        then: "the stashes are created"
        stashes[0].path == stash1.path
        stashes[0].content == stash1.content
        stashes[0].expire == NEVER
        stashes[1].path == stash2.path
        stashes[1].content == stash2.content
        stashes[1].expire == stash2.expire

        when: "time passes"
        sleep(1000)
        stashes = api.stashes.sort { it.path }

        then: "the expiration time decreases"
        stashes[0].expire == NEVER
        stashes[1].expire < stash2.expire
    }

    def "updating stashes by object"() {
        when:
        def stash1 = newStash(PATH1, [key1: "value1"], 30)
        api.createStash(stash1)
        def stashes = api.stashes

        then:
        stashes.size() == 1
        stashes[0] == stash1

        when:
        def stash2 = newStash(PATH1, [key1: "value2", key2: "value3"], 10)
        api.createStash(stash2)
        stashes = api.stashes

        then:
        stashes.size() == 1
        stashes[0] == stash2

        when:
        def stash3 = newStash(PATH1, [key2: "value4"])
        api.createStash(stash3)
        stashes = api.stashes

        then:
        stashes.size() == 1
        stashes[0] == stash3
    }

    def "creating stashes by path and content"() {
        when:
        def content = new JsonObject()
        content.addProperty("key1", "value1")
        content.addProperty("key2", "value2")
        api.createStash(PATH1, content)
        def stashes = api.stashes

        then:
        stashes.size() == 1
        def stash = stashes[0]
        stash.path == PATH1
        stash.content.getAsJsonPrimitive("key1").asString == "value1"
        stash.content.getAsJsonPrimitive("key2").asString == "value2"
        stash.expire == NEVER
    }

    def "updating stashes by path and content"() {
        given: "a pre-existing stash with expiration"
        api.createStash(newStash(PATH1, [key1: "value1"], 15))

        when: "updating it by path and content"
        def content = new JsonObject()
        content.addProperty("key1", "value2")
        api.createStash(PATH1, content)
        def stashes = api.stashes

        then: "both content and expiration is overwritten"
        stashes.size() == 1
        def stash = stashes[0]
        stash.path == PATH1
        stash.content.getAsJsonPrimitive("key1").asString == "value2"
        stash.expire == NEVER
    }

    def "getting stash by path"() {
        given: "a pre-existing stash"
        def stash = newStash(PATH1, [key1: "value1", key2: "value2"])
        api.createStash(stash)

        when: "requesting the stash by path"
        def content = api.getStash(stash.path)

        then: "the content is returned"
        content == stash.content

        when: "requesting a non-existing stash by path"
        api.getStash(PATH3)

        then: "an error is returned"
        thrown(SensuNotFoundException)
    }

    def "deleting stash by path"() {
        given: "a pre-existing stash"
        def stash = newStash(PATH1)
        api.createStash(stash)

        when: "deleting the stash by path"
        api.deleteStash(stash.path)

        and: "requesting the stash by path"
        api.getStash(stash.path)

        then: "the stash no longer exists"
        thrown(SensuNotFoundException)

        when: "deleting a non-existing stash by path"
        api.deleteStash(stash.path)

        then: "an error is returned"
        thrown(SensuNotFoundException)
    }

    private void deleteAllStashes() {
        def stashes = api.stashes
        while (stashes) {
            stashes.each { api.deleteStash(it.path) }
            stashes = api.stashes
        }
    }

    private static StashPath newStash(String path, Map<String, String> content = [:], Integer expire = null) {
        return new StashPath(content, path, expire)
    }
}
