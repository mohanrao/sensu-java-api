package com.commercehub.sensu.api;


public class Event {
    private String id;
    private Client client;
    private EventCheck check;
    private int occurrences;
    private String action;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public EventCheck getCheck() {
        return check;
    }

    public void setCheck(EventCheck check) {
        this.check = check;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", client=" + client +
                ", check=" + check +
                ", occurrences=" + occurrences +
                ", action='" + action + '\'' +
                '}';
    }


}
