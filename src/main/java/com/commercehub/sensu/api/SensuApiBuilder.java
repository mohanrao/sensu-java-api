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

package com.commercehub.sensu.api;

import feign.Feign;
import feign.auth.BasicAuthRequestInterceptor;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class SensuApiBuilder {
    private Feign.Builder builder;

    private SensuApiBuilder() {
        builder = Feign.builder().decoder(new GsonDecoder()).encoder(new GsonEncoder()).errorDecoder(new SensuErrorDecoder());
    }

    public SensuApiBuilder authentication(String username, String password) {
        builder.requestInterceptor(new BasicAuthRequestInterceptor(username, password));
        return this;
    }

    public SensuApi build(String url) {
        return builder.target(SensuApi.class, url);
    }

    public static SensuApiBuilder builder() {
        return new SensuApiBuilder();
    }
}
