package com.example.Test.service;

import com.example.Test.model.Commande;
import com.example.Test.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommandeService {

    List<Commande> getAllCommandes();

    Commande getCommandeByID(Integer id);

    Commande addNewCommande(Commande commande);

}
