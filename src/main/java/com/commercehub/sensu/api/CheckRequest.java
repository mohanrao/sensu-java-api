package com.commercehub.sensu.api;

import java.util.Arrays;
import java.util.List;

public class CheckRequest {
    private String check;
    private List<String> subscribers;

    public CheckRequest() { }

    public CheckRequest(String check, String... subscribers) {
        this(check, Arrays.asList(subscribers));
    }

    public CheckRequest(String check, List<String> subscribers) {
        this.check = check;
        this.subscribers = subscribers;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String toString() {
        return "CheckRequest{" +
                "check='" + check + '\'' +
                ", subscribers=" + subscribers +
                '}';
    }
}
