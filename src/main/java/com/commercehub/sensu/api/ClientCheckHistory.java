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

public class ClientCheckHistory {
    private String check;
    private List<Integer> history;
    private int last_execution;
    private int last_status;

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public List<Integer> getHistory() {
        return history;
    }

    public void setHistory(List<Integer> history) {
        this.history = history;
    }

    public int getLast_execution() {
        return last_execution;
    }

    public void setLast_execution(int last_execution) {
        this.last_execution = last_execution;
    }

    public int getLast_status() {
        return last_status;
    }

    public void setLast_status(int last_status) {
        this.last_status = last_status;
    }

    @Override
    public String toString() {
        return "ClientHistory{" +
                "check='" + check + '\'' +
                ", history=" + history +
                ", last_execution=" + last_execution +
                ", last_status=" + last_status +
                '}';
    }
}
