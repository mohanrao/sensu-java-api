package com.commercehub.sensu.api.data;

public class Socket {
    private String bind;
    private int port;

    public String getBind() {
        return bind;
    }

    public void setBind(String bind) {
        this.bind = bind;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Socket socket = (Socket) o;

        if (port != socket.port) return false;
        return bind != null ? bind.equals(socket.bind) : socket.bind == null;
    }

    @Override
    public int hashCode() {
        int result = bind != null ? bind.hashCode() : 0;
        result = 31 * result + port;
        return result;
    }

    @Override
    public String toString() {
        return "Socket{" +
                "bind='" + bind + '\'' +
                ", port=" + port +
                '}';
    }
}
