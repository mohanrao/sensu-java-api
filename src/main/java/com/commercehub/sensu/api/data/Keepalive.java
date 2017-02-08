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
