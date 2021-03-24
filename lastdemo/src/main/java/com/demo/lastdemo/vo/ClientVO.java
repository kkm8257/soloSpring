package com.demo.lastdemo.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientVO {

    @Id
    private String username;
    private String userpwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
