package com.company;

import java.util.TreeSet;

public class User {
    private String name;
    private TreeSet<String> ipList;
    private long duration;

    public User(String name) {
        this.name = name;
        this.ipList = new TreeSet<>();
        this.duration = 0;
    }

    public String getName() {
        return name;
    }

    public TreeSet<String> getIpList() {
        return ipList;
    }

    public void addIp(String ip) {
        this.ipList.add(ip);
    }

    public long getDuration() {
        return duration;
    }

    public void addDuration(long duration) {
        this.duration += duration;
    }
}