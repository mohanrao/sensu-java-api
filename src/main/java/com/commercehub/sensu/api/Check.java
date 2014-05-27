package com.commercehub.sensu.api;

import java.util.List;

public class Check {
    private String name;
    private String command;
    private List<String> subscribers;
    private int interval;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public String toString() {
        return "Check{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", subscribers=" + subscribers +
                ", interval=" + interval +
                '}';
    }
}
