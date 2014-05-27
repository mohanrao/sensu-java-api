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
