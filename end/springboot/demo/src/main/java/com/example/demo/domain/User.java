package com.example.demo.domain;

import java.util.Arrays;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private int uid;
    private String username;
    private String[] address;
    private Map<String, Integer> map;



    @Override
    public String toString() {
        return "User [uid=" + uid + ", username=" + username + ", address=" + Arrays.toString(address) + ", map=" + map
                + "]";
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

}
