package com.ignite.kss.bpm.demo.dto;

public class EmailParams {

    private String host;
    private String port;
    private String to;
    private String from;
    private String enableSSl;
    private String auth;
    private String subject;
    private String messageText;
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(final String port) {
        this.port = port;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getEnableSSl() {
        return enableSSl;
    }

    public void setEnableSSl(final String enableSSl) {
        this.enableSSl = enableSSl;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(final String auth) {
        this.auth = auth;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(final String messageText) {
        this.messageText = messageText;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EmailParams{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", enableSSl='" + enableSSl + '\'' +
                ", auth='" + auth + '\'' +
                ", subject='" + subject + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
