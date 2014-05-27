package com.commercehub.sensu.api;

public class Event {
    private String client;
    private String check;
    private int occurrences;
    private String output;
    private int status;
    private boolean flapping;

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

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isFlapping() {
        return flapping;
    }

    public void setFlapping(boolean flapping) {
        this.flapping = flapping;
    }

    @Override
    public String toString() {
        return "Event{" +
                "client='" + client + '\'' +
                ", check='" + check + '\'' +
                ", occurences=" + occurrences +
                ", output='" + output + '\'' +
                ", status=" + status +
                ", flapping=" + flapping +
                '}';
    }
}
