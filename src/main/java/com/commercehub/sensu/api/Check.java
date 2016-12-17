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

public class Check {

    private String status;
    private String name;
    private String command;
    private List<String> subscribers;
    private int interval;
    private int issued;
    private int executed;
    private float duration;
    private String output;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getIssued() {
        return issued;
    }

    public void setIssued(int issued) {
        this.issued = issued;
    }

    public int getExecuted() {
        return executed;
    }

    public void setExecuted(int executed) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check check = (Check) o;

        if (interval != check.interval) return false;
        if (issued != check.issued) return false;
        if (executed != check.executed) return false;
        if (Float.compare(check.duration, duration) != 0) return false;
        if (status != null ? !status.equals(check.status) : check.status != null) return false;
        if (name != null ? !name.equals(check.name) : check.name != null) return false;
        if (command != null ? !command.equals(check.command) : check.command != null) return false;
        if (subscribers != null ? !subscribers.equals(check.subscribers) : check.subscribers != null) return false;
        return output != null ? output.equals(check.output) : check.output == null;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (command != null ? command.hashCode() : 0);
        result = 31 * result + (subscribers != null ? subscribers.hashCode() : 0);
        result = 31 * result + interval;
        result = 31 * result + issued;
        result = 31 * result + executed;
        result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
        result = 31 * result + (output != null ? output.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Check{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", subscribers=" + subscribers +
                ", interval=" + interval +
                ", issued=" + issued +
                ", executed=" + executed +
                ", duration=" + duration +
                ", output='" + output + '\'' +
                '}';
    }
}
