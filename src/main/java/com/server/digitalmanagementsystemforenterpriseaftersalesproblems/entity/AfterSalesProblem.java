package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Category;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public class AfterSalesProblem {
    @TableId(type = IdType.AUTO)
    private Integer problemId;
    private Category problemCategory;
    private String problemContent;
    private Status problemStatus;
    private Integer clientId;
    private Integer employeeId;
    private Integer goodsId;
    private LocalDate problemStarttime;
    private LocalDate problemEndtime;

    public Integer getProblemId() {
        return problemId;
    }

    public Category getProblemCategory() {
        return problemCategory;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public Status getProblemStatus() {
        return problemStatus;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public LocalDate getProblemStarttime() {
        return problemStarttime;
    }

    public LocalDate getProblemEndtime() {
        return problemEndtime;
    }

    public void setProblemId(Integer problemId) {
        this.problemId = problemId;
    }

    public void setProblemCategory(Category problemCategory) {
        this.problemCategory = problemCategory;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public void setProblemStatus(Status problemStatus) {
        this.problemStatus = problemStatus;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public void setProblemStarttime(LocalDate problemStarttime) {
        this.problemStarttime = problemStarttime;
    }

    public void setProblemEndtime(LocalDate problemEndtime) {
        this.problemEndtime = problemEndtime;
    }

    @Override
    public String toString() {
        return "AfterSalesProblem{" +
                "problemId=" + problemId +
                ", problemCategory=" + problemCategory +
                ", problemContent='" + problemContent + '\'' +
                ", problemStatus=" + problemStatus +
                ", clientId=" + clientId +
                ", employeeId=" + employeeId +
                ", goodsId=" + goodsId +
                ", problemStarttime=" + problemStarttime +
                ", problemEndtime=" + problemEndtime +
                '}';
    }
}
