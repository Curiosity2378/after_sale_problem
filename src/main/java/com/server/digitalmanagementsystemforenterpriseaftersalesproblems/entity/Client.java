package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Gender;

public class Client {
    @TableId(type = IdType.AUTO)
    private Integer clientId;
    private String clientName;
    private String clientUsername;
    private String clientPassword;
    private Gender clientSex;
    private String clientPhone;
    private String clientAddress;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public Gender getClientSex() {
        return clientSex;
    }

    public void setClientSex(Gender clientSex) {
        this.clientSex = clientSex;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }
}
