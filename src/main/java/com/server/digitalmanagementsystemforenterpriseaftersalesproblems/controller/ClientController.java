package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.google.gson.Gson;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Client;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.ClientService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Resource
    private Gson gson;
    @Resource
    private ClientService clientService;

    @DeleteMapping ("/{id}")
    public String removeClient(@PathVariable Integer id){
        return gson.toJson(clientService.removeClient(id));
    }

    @PutMapping("/delete")
    public String removeAnyClient(@RequestBody List<Integer> clientIds){
        return gson.toJson(clientService.removeAnyClient(clientIds));
    }

    @PutMapping
    public String updateClient(@RequestBody Client client){
        return gson.toJson(clientService.updateClient(client));
    }

    @PostMapping("/clientCount")
    public String clientCount(@RequestBody Client client){
        return gson.toJson(clientService.queryClientCount(client));
    }

    @PostMapping("/condition/{pageNum}")
    public String clientsByCondition(@RequestBody Client client,@PathVariable("pageNum") Integer pageNum) {
        return gson.toJson(clientService.selectClientByCondition(client,pageNum));
    }
}
