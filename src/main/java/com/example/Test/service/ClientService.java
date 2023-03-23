package com.example.Test.service;

import com.example.Test.model.Client;
import com.example.Test.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    Client getClientByID(Integer id);

    Client addNewClient(Client client);

    ResponseEntity<MessageResponse> updateClientByID(Integer id, Client client);

    ResponseEntity<MessageResponse> deleteClientById(Integer id);

    Client findByEmail(String email);

    Boolean existsByEmail(String email);
}
