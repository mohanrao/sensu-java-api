package com.commercehub.sensu.api.data;

import java.util.HashMap;
import java.util.List;

public class Keepalive {
    private String handler;
    private List<String> handlers;
    private HashMap<String, Integer> thresholds;

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

    public HashMap<String, Integer> getThresholds() {
        return thresholds;
    }

    public void setThresholds(HashMap<String, Integer> thresholds) {
        this.thresholds = thresholds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Keepalive keepalive = (Keepalive) o;

        if (handler != null ? !handler.equals(keepalive.handler) : keepalive.handler != null) return false;
        if (handlers != null ? !handlers.equals(keepalive.handlers) : keepalive.handlers != null) return false;
        return thresholds != null ? thresholds.equals(keepalive.thresholds) : keepalive.thresholds == null;
    }

    @Override
    public int hashCode() {
        int result = handler != null ? handler.hashCode() : 0;
        result = 31 * result + (handlers != null ? handlers.hashCode() : 0);
        result = 31 * result + (thresholds != null ? thresholds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Keepalive{" +
                "handler='" + handler + '\'' +
                ", handlers=" + handlers +
                ", thresholds=" + thresholds +
                '}';
    }
}
