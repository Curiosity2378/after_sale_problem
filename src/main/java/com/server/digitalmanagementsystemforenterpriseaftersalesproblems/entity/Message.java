package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.google.gson.annotations.Expose;

public class Message {
    private boolean isSuccess;
    private String message;

    private String token;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Message(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
