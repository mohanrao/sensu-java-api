package com.commercehub.sensu.api;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class SensuApiBuilder {
    public static SensuApi build(String url) {
        return Feign.builder().decoder(new GsonDecoder()).encoder(new GsonEncoder()).errorDecoder(new SensuErrorDecoder()).target(SensuApi.class, url);
    }
}
