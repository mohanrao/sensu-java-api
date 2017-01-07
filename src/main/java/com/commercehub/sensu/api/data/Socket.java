/*
 * Copyright (C) 2016 Commerce Technologies, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
