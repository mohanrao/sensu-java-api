package com.commercehub.sensu.api;

public class EventId {
    private String client;
    private String check;

    public EventId() { }

    public EventId(String client, String check) {
        this.client = client;
        this.check = check;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "EventId{" +
                "client='" + client + '\'' +
                ", check='" + check + '\'' +
                '}';
    }
}
