package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.enums.Category;

public class DayProblemOneCategory {
    private Category problemCategory;
    private Integer num;

    public Category getProblemCategory() {
        return problemCategory;
    }

    public void setProblemCategory(Category problemCategory) {
        this.problemCategory = problemCategory;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "\"" + problemCategory.getDesc() + "\": " + num;
    }
}
