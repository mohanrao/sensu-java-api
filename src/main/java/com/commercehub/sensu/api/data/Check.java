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

public class Check {

    private String name;
    private String command;
    private List<String> subscribers;
    private int interval;
    private String type;
    private String extension;
    private boolean standalone;
    private boolean publish;
    private int timeout;
    private int ttl;
    private boolean autoResolve;
    private boolean forceResolve;
    private boolean handle;
    private String handler;
    private List<String> handlers;
    private int lowFlapThreshold;
    private int highFlapThreshold;
    private String aggregate;
    private List<String> aggregates;
    private Subdue subdue;
    private int status;
    private int issued;
    private int executed;
    private float duration;
    private List<Integer> history;
    private String origin;
    private String source;
    private String output;
    private String clientName;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public boolean isStandalone() {
        return standalone;
    }

    public void setStandalone(boolean standalone) {
        this.standalone = standalone;
    }

    public boolean isPublish() {
        return publish;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public boolean isAutoResolve() {
        return autoResolve;
    }

    public void setAutoResolve(boolean autoResolve) {
        this.autoResolve = autoResolve;
    }

    public boolean isForceResolve() {
        return forceResolve;
    }

    public void setForceResolve(boolean forceResolve) {
        this.forceResolve = forceResolve;
    }

    public boolean isHandle() {
        return handle;
    }

    public void setHandle(boolean handle) {
        this.handle = handle;
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

    public int getLowFlapThreshold() {
        return lowFlapThreshold;
    }

    public void setLowFlapThreshold(int lowFlapThreshold) {
        this.lowFlapThreshold = lowFlapThreshold;
    }

    public int getHighFlapThreshold() {
        return highFlapThreshold;
    }

    public void setHighFlapThreshold(int highFlapThreshold) {
        this.highFlapThreshold = highFlapThreshold;
    }

    public String getAggregate() {
        return aggregate;
    }

    public void setAggregate(String aggregate) {
        this.aggregate = aggregate;
    }

    public List<String> getAggregates() {
        return aggregates;
    }

    public void setAggregates(List<String> aggregates) {
        this.aggregates = aggregates;
    }

    public Subdue getSubdue() {
        return subdue;
    }

    public void setSubdue(Subdue subdue) {
        this.subdue = subdue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check check = (Check) o;

        if (interval != check.interval) return false;
        if (standalone != check.standalone) return false;
        if (publish != check.publish) return false;
        if (timeout != check.timeout) return false;
        if (ttl != check.ttl) return false;
        if (autoResolve != check.autoResolve) return false;
        if (forceResolve != check.forceResolve) return false;
        if (handle != check.handle) return false;
        if (lowFlapThreshold != check.lowFlapThreshold) return false;
        if (highFlapThreshold != check.highFlapThreshold) return false;
        if (status != check.status) return false;
        if (issued != check.issued) return false;
        if (executed != check.executed) return false;
        if (Float.compare(check.duration, duration) != 0) return false;
        if (name != null ? !name.equals(check.name) : check.name != null) return false;
        if (command != null ? !command.equals(check.command) : check.command != null) return false;
        if (subscribers != null ? !subscribers.equals(check.subscribers) : check.subscribers != null) return false;
        if (type != null ? !type.equals(check.type) : check.type != null) return false;
        if (extension != null ? !extension.equals(check.extension) : check.extension != null) return false;
        if (handler != null ? !handler.equals(check.handler) : check.handler != null) return false;
        if (handlers != null ? !handlers.equals(check.handlers) : check.handlers != null) return false;
        if (aggregate != null ? !aggregate.equals(check.aggregate) : check.aggregate != null) return false;
        if (aggregates != null ? !aggregates.equals(check.aggregates) : check.aggregates != null) return false;
        if (subdue != null ? !subdue.equals(check.subdue) : check.subdue != null) return false;
        if (history != null ? !history.equals(check.history) : check.history != null) return false;
        if (origin != null ? !origin.equals(check.origin) : check.origin != null) return false;
        if (source != null ? !source.equals(check.source) : check.source != null) return false;
        if (output != null ? !output.equals(check.output) : check.output != null) return false;
        return clientName != null ? clientName.equals(check.clientName) : check.clientName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (command != null ? command.hashCode() : 0);
        result = 31 * result + (subscribers != null ? subscribers.hashCode() : 0);
        result = 31 * result + interval;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        result = 31 * result + (standalone ? 1 : 0);
        result = 31 * result + (publish ? 1 : 0);
        result = 31 * result + timeout;
        result = 31 * result + ttl;
        result = 31 * result + (autoResolve ? 1 : 0);
        result = 31 * result + (forceResolve ? 1 : 0);
        result = 31 * result + (handle ? 1 : 0);
        result = 31 * result + (handler != null ? handler.hashCode() : 0);
        result = 31 * result + (handlers != null ? handlers.hashCode() : 0);
        result = 31 * result + lowFlapThreshold;
        result = 31 * result + highFlapThreshold;
        result = 31 * result + (aggregate != null ? aggregate.hashCode() : 0);
        result = 31 * result + (aggregates != null ? aggregates.hashCode() : 0);
        result = 31 * result + (subdue != null ? subdue.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + issued;
        result = 31 * result + executed;
        result = 31 * result + (duration != +0.0f ? Float.floatToIntBits(duration) : 0);
        result = 31 * result + (history != null ? history.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (output != null ? output.hashCode() : 0);
        result = 31 * result + (clientName != null ? clientName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Check{" +
                "name='" + name + '\'' +
                ", command='" + command + '\'' +
                ", subscribers=" + subscribers +
                ", interval=" + interval +
                ", type='" + type + '\'' +
                ", extension='" + extension + '\'' +
                ", standalone=" + standalone +
                ", publish=" + publish +
                ", timeout=" + timeout +
                ", ttl=" + ttl +
                ", autoResolve=" + autoResolve +
                ", forceResolve=" + forceResolve +
                ", handle=" + handle +
                ", handler='" + handler + '\'' +
                ", handlers=" + handlers +
                ", lowFlapThreshold=" + lowFlapThreshold +
                ", highFlapThreshold=" + highFlapThreshold +
                ", aggregate='" + aggregate + '\'' +
                ", aggregates=" + aggregates +
                ", subdue=" + subdue +
                ", status=" + status +
                ", issued=" + issued +
                ", executed=" + executed +
                ", duration=" + duration +
                ", history=" + history +
                ", origin='" + origin + '\'' +
                ", source='" + source + '\'' +
                ", output='" + output + '\'' +
                ", clientName='" + clientName + '\'' +
                '}';
    }
}
