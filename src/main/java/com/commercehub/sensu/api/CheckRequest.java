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

import java.util.Arrays;
import java.util.List;

public class CheckRequest {
    private String check;
    private List<String> subscribers;

    public CheckRequest() { }

    public CheckRequest(String check, String... subscribers) {
        this(check, Arrays.asList(subscribers));
    }

    public CheckRequest(String check, List<String> subscribers) {
        this.check = check;
        this.subscribers = subscribers;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<String> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<String> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String toString() {
        return "CheckRequest{" +
                "check='" + check + '\'' +
                ", subscribers=" + subscribers +
                '}';
    }
}
