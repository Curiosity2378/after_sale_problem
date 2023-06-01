package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.ProblemData;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl.AfterSalesProblemServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/problem")
public class AfterSalesProblemController {
    @Resource
    private Gson gson;
    @Resource
    private AfterSalesProblemServiceImpl afterSalesProblemService;

    @DeleteMapping ("/{id}")
    public String removeProblem(@PathVariable Integer id){
        return gson.toJson(afterSalesProblemService.removeProblem(id));
    }

    @PutMapping("/delete")
    public String removeAnyClient(@RequestBody List<Integer> problemIds){
        return gson.toJson(afterSalesProblemService.removeAnyProblem(problemIds));
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
        return gson.toJson(afterSalesProblemService.queryCategoryInfo());
    }

    @GetMapping("/status")
    public String statusInfo(){
        return gson.toJson(afterSalesProblemService.queryStatusInfo());
    }

    @GetMapping("/goods")
    public String goodsInfo(){
        return gson.toJson(afterSalesProblemService.queryGoodsInfo());
    }

    @PostMapping("/condition/{pageNum}")
    public String problemByCondition(@RequestBody ProblemData problemData, @PathVariable("pageNum") Integer pageNum) {
        return gson.toJson(afterSalesProblemService.selectProblemByCondition(problemData,pageNum));
    }

    @PostMapping("/problemCount")
    public String problemCount(@RequestBody ProblemData problemData){
        return gson.toJson(afterSalesProblemService.queryProblemCount(problemData));
    }
}
