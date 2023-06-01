package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Category;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class ProblemData {
    private Integer problemId;
    private Category problemCategory;
    private String problemContent;
    private Status problemStatus;
    private String clientUsername;
    private String employeeUsername;
    private String goodsName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate problemStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate problemEndtime;

    public Integer getProblemId() {
        return problemId;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public Category getProblemCategory() {
        return problemCategory;
    }

    public void setProblemCategory(Category problemCategory) {
        this.problemCategory = problemCategory;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public Status getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(Status problemStatus) {
        this.problemStatus = problemStatus;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public LocalDate getProblemStarttime() {
        return problemStarttime;
    }

    public void setProblemStarttime(LocalDate problemStarttime) {
        this.problemStarttime = problemStarttime;
    }

    public LocalDate getProblemEndtime() {
        return problemEndtime;
    }

    public void setProblemEndtime(LocalDate problemEndtime) {
        this.problemEndtime = problemEndtime;
    }

    @Override
    public String toString() {
        return "ProblemData{" +
                "problemId=" + problemId +
                ", problemCategory=" + problemCategory +
                ", problemContent='" + problemContent + '\'' +
                ", problemStatus=" + problemStatus +
                ", clientUsername='" + clientUsername + '\'' +
                ", employeeUsername='" + employeeUsername + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", problemStarttime=" + problemStarttime +
                ", problemEndtime=" + problemEndtime +
                '}';
    }
}
