package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Employee;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Message;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper.EmployeeMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.EmployeeService;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee selectEmployee(String employeeUsername) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_username",employeeUsername);
        return employeeMapper.selectOne(queryWrapper);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        return employeeMapper.insert(employee) == 1;
    }

    @Override
    public boolean removeEmployee(Integer employeeId) {
        return employeeMapper.deleteById(employeeId) == 1;
    }

    @Override
    public boolean removeAnyEmployee(List<Integer> employeeIds) {
        return employeeMapper.deleteBatchIds(employeeIds) == employeeIds.size();
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeMapper.updateById(employee) == 1;
    }

    @Override
    public Message checkEmployee(String employeeUsername) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_username",employeeUsername);
        Employee employeeResult = employeeMapper.selectOne(queryWrapper);
        if(Objects.isNull(employeeResult)){
            return new Message(false,"该账户不存在！");
        }else{
            return new Message(true,"该账户存在！");
        }
    }

    @Override
    public Message login(Employee employee) {
        Message checkResult = checkEmployee(employee.getEmployeeUsername());
        if(!checkResult.isSuccess()){
            return checkResult;
        }
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_username",employee.getEmployeeUsername());
        Employee employeeResult = employeeMapper.selectOne(queryWrapper);
        if(employeeResult.getEmployeePassword().equals(employee.getEmployeePassword())){
            Message message = new Message(true,employee.getEmployeeUsername());
            message.setToken(JwtUtil.createToken());
            return message;
        }
        return new Message(false,"密码错误");
    }

    @Override
    public boolean resetPassword(Employee employee) {
        Integer isPassword = employeeMapper.updateEmployeePassword(employee.getEmployeePassword(), employee.getEmployeeEmail());
        return isPassword == 1;
    }

    @Override
    public Long queryEmployeeCount(Employee employee) {
        return employeeMapper.selectCount(queryWrapper(employee));
    }

    @Override
    public List<Employee> selectEmployeeByCondition(Employee employee, Integer pageNum) {
        var page = new Page<Employee>(pageNum,10);
        employeeMapper.selectPage(page,queryWrapper(employee));
        return page.getRecords();
    }

    private QueryWrapper<Employee> queryWrapper(Employee employee){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        if(employee.getEmployeeUsername() != "" && employee.getEmployeeUsername() != null){
            queryWrapper.eq("employee_username",employee.getEmployeeUsername());
        }
        if(employee.getEmployeeSex() != null){
            queryWrapper.eq("employee_sex",employee.getEmployeeSex());
        }
        if(employee.getEmployeeDepartment() != "" && employee.getEmployeeDepartment() != null){
            queryWrapper.eq("employee_department",employee.getEmployeeDepartment());
        }
        return queryWrapper;
    }
}
