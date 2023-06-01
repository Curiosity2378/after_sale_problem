package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Employee;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Message;

import java.util.List;

public interface EmployeeService {
    boolean addEmployee(Employee employee);
    boolean removeEmployee(Integer employeeId);
    boolean removeAnyEmployee(List<Integer> employeeIds);
    boolean updateEmployee(Employee employee);
    Message checkEmployee(String employeeUsername);
    Employee selectEmployee(String employeeUsername);
    Message login(Employee employee);
    boolean resetPassword(Employee employee);
    Long queryEmployeeCount(Employee employee);
    List<Employee> selectEmployeeByCondition(Employee employee,Integer pageNum);
}
