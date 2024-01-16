package com.example.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private int uid;
    private String username;

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUid(){
        return this.uid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
}
