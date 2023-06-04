package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.controller;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.Client;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.ClientService;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.utils.JsonUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Resource
    private ClientService clientService;

    @DeleteMapping ("/{id}")
    public String removeClient(@PathVariable Integer id){
        return JsonUtil.toJson(clientService.removeClient(id));
    }

    @PutMapping("/delete")
    public String removeAnyClient(@RequestBody List<Integer> clientIds){
        return JsonUtil.toJson(clientService.removeAnyClient(clientIds));
    }

    @PutMapping
    public String updateClient(@RequestBody Client client){
        return JsonUtil.toJson(clientService.updateClient(client));
    }

    @PostMapping("/clientCount")
    public String clientCount(@RequestBody Client client){
        return JsonUtil.toJson(clientService.queryClientCount(client));
    }

    @PostMapping("/condition/{pageNum}")
    public String clientsByCondition(@RequestBody Client client,@PathVariable("pageNum") Integer pageNum) {
        return JsonUtil.toJson(clientService.selectClientByCondition(client,pageNum));
    }
}
