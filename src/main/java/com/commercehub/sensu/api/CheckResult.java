package com.commercehub.sensu.api;

import java.util.HashMap;
import java.util.List;

public class CheckResult {
    private String name;
    private String type;
    private String command;
    private String extension;
    private boolean standalone;
    private List<String> subscribers;
    private boolean publish;
    private int interval;
    private int timeout;
    private int ttl;
    private boolean autoResolve;
    private boolean forceResolve;
    private boolean handle;
    private int lowFlapThreshold;
    private int highFlapThreshold;
    private String aggregate;
    private List<String> aggregates;
    private HashMap subdue;
    private String contact;
    private List<String> contacts;
    private String handler;
    private List<String> handlers;
    private int issued;
    private String output;
    private int status;
    private List<Integer> history;
    private String source;
    private String origin;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public List<String> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<String> handlers) {
        this.handlers = handlers;
    }

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
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

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckResult that = (CheckResult) o;

        if (interval != that.interval) return false;
        if (issued != that.issued) return false;
        if (status != that.status) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (command != null ? !command.equals(that.command) : that.command != null) return false;
        if (subscribers != null ? !subscribers.equals(that.subscribers) : that.subscribers != null) return false;
        if (handler != null ? !handler.equals(that.handler) : that.handler != null) return false;
        if (handlers != null ? !handlers.equals(that.handlers) : that.handlers != null) return false;
        if (output != null ? !output.equals(that.output) : that.output != null) return false;
        if (history != null ? !history.equals(that.history) : that.history != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        return !(origin != null ? !origin.equals(that.origin) : that.origin != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (command != null ? command.hashCode() : 0);
        result = 31 * result + (subscribers != null ? subscribers.hashCode() : 0);
        result = 31 * result + interval;
        result = 31 * result + (handler != null ? handler.hashCode() : 0);
        result = 31 * result + (handlers != null ? handlers.hashCode() : 0);
        result = 31 * result + issued;
        result = 31 * result + (output != null ? output.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", subscribers=" + subscribers +
                ", interval=" + interval +
                ", handler='" + handler + '\'' +
                ", handlers=" + handlers +
                ", issued=" + issued +
                ", output='" + output + '\'' +
                ", status=" + status +
                ", history=" + history +
                ", source='" + source + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
