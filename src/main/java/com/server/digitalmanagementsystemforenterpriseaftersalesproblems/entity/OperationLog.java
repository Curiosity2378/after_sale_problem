package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class OperationLog implements Serializable {

    private Long id;

    private String userName;

    private String description;

    private String module;

    private String operationContent;

    private String clientIp;

    private LocalDate operationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIP) {
        this.clientIp = clientIP;
    }

    public LocalDate getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(LocalDate operationTime) {
        this.operationTime = operationTime;
    }
}
