package com.commercehub.sensu.api.data;

public class DeRegistration {
    private String handler;

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DeRegistration that = (DeRegistration) o;

        return handler != null ? handler.equals(that.handler) : that.handler == null;
    }

    @Override
    public int hashCode() {
        return handler != null ? handler.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "DeRegistration{" +
                "handler='" + handler + '\'' +
                '}';
    }
}
