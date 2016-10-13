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

public class EventCheck {
    private String command;
    private List<String> subscribers;
    private int interval;
    private String name;
    private long issued;
    private long executed;
    private float duration;
    private String output;
    private int status;
    private List<String>history;
    private int totalStateChange;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getIssued() {
        return issued;
    }

    public void setIssued(long issued) {
        this.issued = issued;
    }

    public long getExecuted() {
        return executed;
    }

    public void setExecuted(long executed) {
        this.executed = executed;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
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

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }

    public int getTotalStateChange() {
        return totalStateChange;
    }

    public void setTotalStateChange(int totalStateChange) {
        this.totalStateChange = totalStateChange;
    }

    @Override
    public String toString() {
        return "EventCheck{" +
                "command='" + command + '\'' +
                ", subscribers=" + subscribers +
                ", interval=" + interval +
                ", name='" + name + '\'' +
                ", issued=" + issued +
                ", executed=" + executed +
                ", duration=" + duration +
                ", output='" + output + '\'' +
                ", status=" + status +
                ", history=" + history +
                ", totalStateChange=" + totalStateChange +
                '}';
    }
}
