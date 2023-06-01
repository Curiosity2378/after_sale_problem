package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.*;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper.AfterSalesProblemMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.AfterSalesProblemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AfterSalesProblemServiceImpl implements AfterSalesProblemService {

    @Resource
    private AfterSalesProblemMapper afterSalesProblemMapper;

    @Override
    public boolean removeProblem(Integer problemId) {
        return afterSalesProblemMapper.deleteById(problemId) == 1;
    }

    @Override
    public boolean removeAnyProblem(List<Integer> problemIds) {
        return afterSalesProblemMapper.deleteBatchIds(problemIds) == problemIds.size();
    }

    @Override
    public List<ProblemData> selectProblemByCondition(ProblemData problemData, Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return afterSalesProblemMapper.selectProblemByCondition(problemData);
    }

    @Override
    public Long queryProblemCount(ProblemData problemData) {
        return afterSalesProblemMapper.queryProblemCount(problemData);
    }

    @Override
    public List<DayProblemCategoryStatistics> homeQuery() {
        List<DayProblemCategoryStatistics> dayProblemStatistics = new ArrayList<>();
        for(int i = 1;i <= 7;i++){
            LocalDate condition = LocalDate.now();
            List<DayProblemOneCategory> dayOneCategoryProblemNumList = new ArrayList<>();
            DayProblemCategoryStatistics dayProblemCategoryStatistics = new DayProblemCategoryStatistics();
            dayProblemCategoryStatistics.setCondition(condition.minusDays(i));
            dayOneCategoryProblemNumList = afterSalesProblemMapper.selectProblemCategoryByStarttime(i);
            dayProblemCategoryStatistics.setDayProblemCategoryStatistics(dayOneCategoryProblemNumList);
            dayProblemStatistics.add(dayProblemCategoryStatistics);
        }
        return dayProblemStatistics;
    }

    @Override
    public List<Integer> totalAndDayQuery(Boolean isToday) {
        List<Integer> results = new ArrayList<>();
        for(int i = 0;i < 4;i++){
            results.add(afterSalesProblemMapper.selectAllByProblemStatus(i,isToday));
        }
        return results;
    }

    @Override
    public List<Integer> queryCategoryInfo() {
        return afterSalesProblemMapper.selectProblemCategory();
    }

    @Override
    public List<Integer> queryStatusInfo() {
        return afterSalesProblemMapper.selectProblemStatus();
    }

    @Override
    public List<DayProblemOneGoods> queryGoodsInfo() {
        return afterSalesProblemMapper.selectProblemGoods();
    }

}
