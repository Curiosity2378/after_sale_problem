package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.ProblemData;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl.AfterSalesProblemServiceImpl;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/problem")
public class AfterSalesProblemController {

    @Resource
    private AfterSalesProblemServiceImpl afterSalesProblemService;

    @DeleteMapping ("/{id}")
    public String removeProblem(@PathVariable Integer id){
        return JsonUtil.toJson(afterSalesProblemService.removeProblem(id));
    }

    @PutMapping("/delete")
    public String removeAnyClient(@RequestBody List<Integer> problemIds){
        return JsonUtil.toJson(afterSalesProblemService.removeAnyProblem(problemIds));
    }

    @GetMapping("/seven")
    public String querySeven(){
        return afterSalesProblemService.homeQuery().toString();
    }

    @GetMapping("/totalAndDay")
    public String totalAndDay(@RequestParam Boolean isToday){
        return afterSalesProblemService.totalAndDayQuery(isToday).toString();
    }

    @GetMapping("/category")
    public String categoryInfo(){
        return JsonUtil.toJson(afterSalesProblemService.queryCategoryInfo());
    }

    @GetMapping("/status")
    public String statusInfo(){
        return JsonUtil.toJson(afterSalesProblemService.queryStatusInfo());
    }

    @GetMapping("/goods")
    public String goodsInfo(){
        return JsonUtil.toJson(afterSalesProblemService.queryGoodsInfo());
    }

    @PostMapping("/condition/{pageNum}")
    public String problemByCondition(@RequestBody ProblemData problemData, @PathVariable("pageNum") Integer pageNum) {
        return JsonUtil.toJson(afterSalesProblemService.selectProblemByCondition(problemData,pageNum));
    }

    @PostMapping("/problemCount")
    public String problemCount(@RequestBody ProblemData problemData){
        return JsonUtil.toJson(afterSalesProblemService.queryProblemCount(problemData));
    }
}
