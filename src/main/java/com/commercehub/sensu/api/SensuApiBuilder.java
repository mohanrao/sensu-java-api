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
