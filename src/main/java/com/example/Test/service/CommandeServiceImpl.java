package com.example.Test.service;

import com.example.Test.model.Client;
import com.example.Test.model.Commande;
import com.example.Test.model.Produit;
import com.example.Test.repository.CommandeRepository;
import com.example.Test.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommandeServiceImpl implements CommandeService{
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private SendMailService sendMailService;

    @Override
    public List<Commande> getAllCommandes() {
         return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeByID(Integer id) {
        return commandeRepository.findById(id).orElseThrow();
    }

    @Override
    public Commande addNewCommande(Commande commande) {
        List<Produit> produits = commande.getProduits();
        for (Produit produit : produits) {
            Integer quantite = produit.getQuantité();
            produit.setQuantité(quantite - 1);
        }
        return commandeRepository.save(commande);
    }

}
