package com.example.Test.controller;


import com.example.Test.model.Client;
import com.example.Test.response.MessageResponse;
import com.example.Test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/findByEmail")
    public Client findByEmail(String email){
        Client ClientByEmail = clientService.findByEmail(email);
        return ClientByEmail;
    }

    @GetMapping("/existsByEmail")
    public Boolean existsByEmail(String email){
        Boolean ClientExistsByEmail = clientService.existsByEmail(email);
        return ClientExistsByEmail;
    }

    @GetMapping("/")
    public List<Client> getAllClients(){
        List<Client> Clients =  clientService.getAllClients();
        return Clients;
    }
    @GetMapping("/{id}")
    public Client getClientByID(@PathVariable("id") Integer id){
        Client client = clientService.getClientByID(id);
        return client;
    }
    @PostMapping("/addClient")
    public Client addNewUClient(@RequestBody Client client){
        Client client1 = clientService.addNewClient(client);
        return client1;
    }
    @PutMapping("/editClient/{id}")
    public ResponseEntity<MessageResponse> updateClientByID(@PathVariable("id") Integer id, @RequestBody Client client){
        ResponseEntity<MessageResponse> response = clientService.updateClientByID(id, client);
        return response;
    }
    @DeleteMapping("/deleteClient/{id}")
    public ResponseEntity<MessageResponse> deleteClientById(@PathVariable("id") Integer id){
        ResponseEntity<MessageResponse> response = clientService.deleteClientById(id);
        return response;
    }





}
