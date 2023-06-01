package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.*;


import java.util.List;

public interface AfterSalesProblemService {

    boolean removeProblem(Integer problemId);

    boolean removeAnyProblem(List<Integer> problemIds);

    List<ProblemData> selectProblemByCondition(ProblemData problemData,Integer pageNum);

    Long queryProblemCount(ProblemData problemData);

    List<DayProblemCategoryStatistics> homeQuery();

    List<Integer> totalAndDayQuery(Boolean isToday);

    List<Integer> queryCategoryInfo();

    List<Integer> queryStatusInfo();

    List<DayProblemOneGoods> queryGoodsInfo();
}
