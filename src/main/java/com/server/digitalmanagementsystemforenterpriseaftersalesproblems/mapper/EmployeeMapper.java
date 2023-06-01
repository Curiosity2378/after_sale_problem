package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper extends BaseMapper<Employee> {

    Integer updateEmployeePassword(@Param("employeePassword") String employeePassword,@Param("employeeEmail") String employeeEmail);
}
