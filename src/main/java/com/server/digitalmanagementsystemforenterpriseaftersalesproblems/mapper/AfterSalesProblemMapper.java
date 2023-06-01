package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AfterSalesProblemMapper extends BaseMapper<AfterSalesProblem> {

    List<DayProblemOneCategory> selectProblemCategoryByStarttime(Integer num);

    Integer selectAllByProblemStatus(@Param("num") Integer num,@Param("isToday") Boolean isToday);

    List<Integer> selectProblemCategory();

    List<Integer> selectProblemStatus();

    List<DayProblemOneGoods> selectProblemGoods();

    List<ProblemData> selectProblemByCondition(ProblemData problemData);

    Long queryProblemCount(ProblemData problemData);
}
