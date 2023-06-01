package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Client;

import java.util.List;

public interface ClientService {
    boolean removeClient(Integer clientId);
    boolean removeAnyClient(List<Integer> clientIdList);
    boolean updateClient(Client client);
    Long queryClientCount(Client client);
    List<Client> selectClientByCondition(Client client,Integer pageNum);
}
