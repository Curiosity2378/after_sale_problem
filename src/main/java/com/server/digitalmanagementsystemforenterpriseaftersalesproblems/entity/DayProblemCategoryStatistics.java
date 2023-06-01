package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity;


import java.time.LocalDate;
import java.util.List;


public class DayProblemCategoryStatistics {
    private LocalDate Condition;
    private List<DayProblemOneCategory> dayProblemCategoryStatistics;

    public LocalDate getCondition() {
        return Condition;
    }

    public void setCondition(LocalDate condition) {
        Condition = condition;
    }

    public List<DayProblemOneCategory> getDayProblemCategoryStatistics() {
        return dayProblemCategoryStatistics;
    }

    public void setDayProblemCategoryStatistics(List<DayProblemOneCategory> dayProblemCategoryStatistics) {
        this.dayProblemCategoryStatistics = dayProblemCategoryStatistics;
    }

    @Override
    public String toString() {
        String string = "";
        for(int i = 0;i < dayProblemCategoryStatistics.size();i++){
            string = string + "," + dayProblemCategoryStatistics.get(i).toString();
        }
        return "{ \"condition\": \"" + Condition.toString() + "\"" + string + '}';
    }
}
