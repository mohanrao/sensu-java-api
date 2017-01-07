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

public class Subdue {

    private String at;
    private List<String> days;
    private String begin;
    private String end;
    private List<HashMap<String, String>> exceptions;

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<HashMap<String, String>> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<HashMap<String, String>> exceptions) {
        this.exceptions = exceptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subdue subdue = (Subdue) o;

        if (at != null ? !at.equals(subdue.at) : subdue.at != null) return false;
        if (days != null ? !days.equals(subdue.days) : subdue.days != null) return false;
        if (begin != null ? !begin.equals(subdue.begin) : subdue.begin != null) return false;
        if (end != null ? !end.equals(subdue.end) : subdue.end != null) return false;
        return exceptions != null ? exceptions.equals(subdue.exceptions) : subdue.exceptions == null;
    }

    @Override
    public int hashCode() {
        int result = at != null ? at.hashCode() : 0;
        result = 31 * result + (days != null ? days.hashCode() : 0);
        result = 31 * result + (begin != null ? begin.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + (exceptions != null ? exceptions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subdue{" +
                "at='" + at + '\'' +
                ", days=" + days +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", exceptions=" + exceptions +
                '}';
    }
}
