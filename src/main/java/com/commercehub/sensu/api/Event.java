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

package com.commercehub.sensu.api;


import java.util.List;

public class Event {
    private String id;
    private int timestamp;
    private String action;
    private int occurrences;
    private int occurrencesWatermark;
    private CheckResult check;
    private Client client;
    private boolean silenced;
    private List<String> silencedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public int getOccurrencesWatermark() {
        return occurrencesWatermark;
    }

    public void setOccurrencesWatermark(int occurrencesWatermark) {
        this.occurrencesWatermark = occurrencesWatermark;
    }

    public CheckResult getCheck() {
        return check;
    }

    public void setCheck(CheckResult check) {
        this.check = check;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isSilenced() {
        return silenced;
    }

    public void setSilenced(boolean silenced) {
        this.silenced = silenced;
    }

    public List<String> getSilencedBy() {
        return silencedBy;
    }

    public void setSilencedBy(List<String> silencedBy) {
        this.silencedBy = silencedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (timestamp != event.timestamp) return false;
        if (occurrences != event.occurrences) return false;
        if (occurrencesWatermark != event.occurrencesWatermark) return false;
        if (silenced != event.silenced) return false;
        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (action != null ? !action.equals(event.action) : event.action != null) return false;
        if (check != null ? !check.equals(event.check) : event.check != null) return false;
        if (client != null ? !client.equals(event.client) : event.client != null) return false;
        return !(silencedBy != null ? !silencedBy.equals(event.silencedBy) : event.silencedBy != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + timestamp;
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + occurrences;
        result = 31 * result + occurrencesWatermark;
        result = 31 * result + (check != null ? check.hashCode() : 0);
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (silenced ? 1 : 0);
        result = 31 * result + (silencedBy != null ? silencedBy.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", action='" + action + '\'' +
                ", occurrences=" + occurrences +
                ", occurrencesWatermark=" + occurrencesWatermark +
                ", check=" + check +
                ", client=" + client +
                ", silenced=" + silenced +
                ", silencedBy=" + silencedBy +
                '}';
    }
}
