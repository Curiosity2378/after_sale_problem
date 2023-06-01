package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Client;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.mapper.ClientMapper;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Resource
    private ClientMapper clientMapper;

    @Override
    public boolean removeClient(Integer clientId) {
        return clientMapper.deleteById(clientId) != 0;
    }

    @Override
    public boolean removeAnyClient(List<Integer> clientIdList) {
        return clientMapper.deleteBatchIds(clientIdList) == clientIdList.size();
    }

    @Override
    public boolean updateClient(Client client) {
        return clientMapper.updateById(client) == 1;
    }

    @Override
    public Long queryClientCount(Client client) {
        return clientMapper.selectCount(queryWrapper(client));
    }

    @Override
    public List<Client> selectClientByCondition(Client client,Integer pageNum) {
        var page = new Page<Client>(pageNum,10);
        clientMapper.selectPage(page,queryWrapper(client));
        return page.getRecords();
    }

    private QueryWrapper<Client> queryWrapper(Client client){
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();
        if(client.getClientUsername() != "" && client.getClientUsername() != null){
            queryWrapper.eq("client_username",client.getClientUsername());
        }
        if(client.getClientName() != "" && client.getClientName() != null){
            queryWrapper.eq("client_name",client.getClientName());
        }
        if(client.getClientPhone() != "" && client.getClientPhone() != null){
            queryWrapper.eq("client_phone",client.getClientPhone());
        }
        return queryWrapper;
    }
}
