package com.commercehub.sensu.api;

import feign.Response;
import feign.codec.ErrorDecoder;

class SensuErrorDecoder implements ErrorDecoder {
    private static final int NOT_FOUND = 404;
    private static final int MALFORMED = 400;

    @Override
    public Exception decode(String methodKey, Response response) {
        String message = String.format("status %s reading %s", response.status(), methodKey);
        switch (response.status()) {
            case NOT_FOUND: return new SensuNotFoundException(message);
            case MALFORMED: return new SensuMalformedDataException(message);
            default: return new SensuErrorException(message);
        }
    }
}
