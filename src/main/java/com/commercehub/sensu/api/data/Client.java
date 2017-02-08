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

import java.util.List;

public class Client {
    private String name;
    private String address;
    private List<String> subscriptions;
    private String version;
    private int timestamp;
    private boolean safeMode;
    private List<String> redactData;
    private Socket socket;
    private boolean monitorKeepalives;
    private Keepalive keepalive;
    private Registration registration;
    private boolean deRegister;
    private DeRegistration deregistration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<String> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSafeMode() {
        return safeMode;
    }

    public void setSafeMode(boolean safeMode) {
        this.safeMode = safeMode;
    }

    public List<String> getRedactData() {
        return redactData;
    }

    public void setRedactData(List<String> redactData) {
        this.redactData = redactData;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public boolean isMonitorKeepalives() {
        return monitorKeepalives;
    }

    public void setMonitorKeepalives(boolean monitorKeepalives) {
        this.monitorKeepalives = monitorKeepalives;
    }

    public Keepalive getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(Keepalive keepalive) {
        this.keepalive = keepalive;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }

    public boolean isDeRegister() {
        return deRegister;
    }

    public void setDeRegister(boolean deRegister) {
        this.deRegister = deRegister;
    }

    public DeRegistration getDeregistration() {
        return deregistration;
    }

    public void setDeregistration(DeRegistration deregistration) {
        this.deregistration = deregistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (timestamp != client.timestamp) return false;
        if (safeMode != client.safeMode) return false;
        if (monitorKeepalives != client.monitorKeepalives) return false;
        if (deRegister != client.deRegister) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (subscriptions != null ? !subscriptions.equals(client.subscriptions) : client.subscriptions != null) return false;
        if (version != null ? !version.equals(client.version) : client.version != null) return false;
        if (redactData != null ? !redactData.equals(client.redactData) : client.redactData != null) return false;
        if (socket != null ? !socket.equals(client.socket) : client.socket != null) return false;
        if (keepalive != null ? !keepalive.equals(client.keepalive) : client.keepalive != null) return false;
        if (registration != null ? !registration.equals(client.registration) : client.registration != null) return false;
        return deregistration != null ? deregistration.equals(client.deregistration) : client.deregistration == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (subscriptions != null ? subscriptions.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + timestamp;
        result = 31 * result + (safeMode ? 1 : 0);
        result = 31 * result + (redactData != null ? redactData.hashCode() : 0);
        result = 31 * result + (socket != null ? socket.hashCode() : 0);
        result = 31 * result + (monitorKeepalives ? 1 : 0);
        result = 31 * result + (keepalive != null ? keepalive.hashCode() : 0);
        result = 31 * result + (registration != null ? registration.hashCode() : 0);
        result = 31 * result + (deRegister ? 1 : 0);
        result = 31 * result + (deregistration != null ? deregistration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", subscriptions=" + subscriptions +
                ", version='" + version + '\'' +
                ", timestamp=" + timestamp +
                ", safeMode=" + safeMode +
                ", redactData=" + redactData +
                ", socket=" + socket +
                ", monitorKeepalives=" + monitorKeepalives +
                ", keepalive=" + keepalive +
                ", registration=" + registration +
                ", deRegister=" + deRegister +
                ", deregistration=" + deregistration +
                '}';
    }
}
