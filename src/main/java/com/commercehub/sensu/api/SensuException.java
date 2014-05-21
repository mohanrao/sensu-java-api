package com.commercehub.sensu.api;

public class SensuException extends RuntimeException {
    public SensuException(String message) {
        super(message);
    }

    public SensuException(String message, Throwable cause) {
        super(message, cause);
    }
}
