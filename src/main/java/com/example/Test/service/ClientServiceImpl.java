package com.example.Test.service;

import com.example.Test.model.Client;
import com.example.Test.repository.ClientRepository;
import com.example.Test.response.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientByID(Integer id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public Client addNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public ResponseEntity<MessageResponse> updateClientByID(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client editedClient = optionalClient.get();
            editedClient.setNom(client.getNom());
            editedClient.setPrenom(client.getPrenom());
            editedClient.setEmail(client.getEmail());
            editedClient.setPassword(client.getPassword());
            editedClient.setCommande(client.getCommande());

            clientRepository.save(editedClient);
            MessageResponse messageResponse = new MessageResponse("Client edited successfully");

            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<MessageResponse> deleteClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
            MessageResponse messageResponse = new MessageResponse("Client deleted successfully");
            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public Client  findByEmail(String email) {
            return clientRepository.findByEmail(email).get();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return clientRepository.existsByEmail(email);
    }
}
