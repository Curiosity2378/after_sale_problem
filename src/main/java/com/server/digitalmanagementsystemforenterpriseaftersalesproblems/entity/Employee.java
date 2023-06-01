package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Gender;


public class Employee {
    @TableId(type = IdType.AUTO)
    private Integer employeeId;
    private String employeeUsername;
    private String employeePassword;
    private Gender employeeSex;
    private String employeeDepartment;
    private String employeeEmail;
    private Boolean isManage;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public Gender getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Gender employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Boolean getManage() {
        return isManage;
    }

    public void setManage(Boolean manage) {
        isManage = manage;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeUsername='" + employeeUsername + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", employeeSex=" + employeeSex +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", isManage=" + isManage +
                '}';
    }
}
