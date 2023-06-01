package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Employee;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Message;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.EmployeeService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private Gson gson;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/{employeeUsername}")
    public String selectOneEmployee(@PathVariable("employeeUsername") String employeeUsername){
        return gson.toJson(employeeService.selectEmployee(employeeUsername));
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee){
        return gson.toJson(employeeService.addEmployee(employee));
    }

    @GetMapping("/checkUsername/{employeeUsername}")
    public String checkUsername(@PathVariable("employeeUsername") String employeeUsername){
        return gson.toJson((employeeService.checkEmployee(employeeUsername)));
    }

    @DeleteMapping("/{id}")
    public String removeEmployee(@PathVariable("id") Integer employeeId){
        return gson.toJson(employeeService.removeEmployee(employeeId));
    }

    @PutMapping("/delete")
    public String removeAnyEmployee(@RequestBody List<Integer> employeeIds){
        return gson.toJson(employeeService.removeAnyEmployee(employeeIds));
    }

    @PutMapping
    public String updateEmployee(@RequestBody Employee employee){
        return gson.toJson(employeeService.updateEmployee(employee));
    }

    @PostMapping("/login")
    public String login(@RequestBody Employee employee){
        return gson.toJson(employeeService.login(employee));
    }

    @PostMapping("/employeeCount")
    public String count(@RequestBody Employee employee){
        return gson.toJson(employeeService.queryEmployeeCount(employee));
    }

    @PostMapping("/condition/{pageNum}")
    public String employeeByCondition(@RequestBody Employee employee,@PathVariable("pageNum") Integer pageNum){
        return gson.toJson(employeeService.selectEmployeeByCondition(employee,pageNum));
    }

    @PostMapping("/{code}")
    public String resetPassword(@RequestBody Employee employee,@PathVariable("code") Integer code){
        String redisCode = stringRedisTemplate.opsForValue().get(employee.getEmployeeEmail());
        if(redisCode == null){
            return gson.toJson(false);
        }else{
            Integer verifyCode = Integer.valueOf(redisCode);
            if(verifyCode.equals(code)){
                return gson.toJson(employeeService.resetPassword(employee));
            }else{
                return gson.toJson(false);
            }
        }
    }

}
