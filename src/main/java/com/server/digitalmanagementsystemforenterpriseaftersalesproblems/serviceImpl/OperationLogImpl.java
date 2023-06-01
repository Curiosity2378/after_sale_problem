package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.OperationLog;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper.OperationLogMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.OperationLogService;

import javax.annotation.Resource;

public class OperationLogImpl implements OperationLogService {

    @Resource
    private OperationLogMapper operationLogMapper;
    @Override
    public void insert(OperationLog operationLog) {
        operationLogMapper.insert(operationLog);
    }
}
