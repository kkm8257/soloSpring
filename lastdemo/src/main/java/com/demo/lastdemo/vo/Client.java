package com.demo.lastdemo.vo;

import sun.jvm.hotspot.debugger.win32.coff.AuxSectionDefinitionsRecord;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Client {

    @Id
    private int idx_client;
    private String clientEmail;
    private String clientPwd;
    private String nick;
    private Date regDate;
    private Date modDate;





    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Client() {



    }

    public Client(String clientEmail, String clientPwd, String nick, Date regDate, Date modDate) {
        this.clientEmail = clientEmail;
        this.clientPwd = clientPwd;
        this.nick = nick;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    public int getIdx_client() {
        return idx_client;
    }

    public void setIdx_client(int idx_client) {
        this.idx_client = idx_client;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPwd() {
        return clientPwd;
    }

    public void setClientPwd(String clientPwd) {
        this.clientPwd = clientPwd;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }
}
