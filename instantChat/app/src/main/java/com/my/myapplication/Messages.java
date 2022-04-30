package com.my.myapplication;

public class Messages {

    private String message,type,from;
    private long time;
    public Messages(){}

    public Messages(String message, String type, long time) {
        this.message = message;
        this.type = type;
        this.time = time;
    }

    public Messages(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public long getTime() {
        return time;
    }
}
