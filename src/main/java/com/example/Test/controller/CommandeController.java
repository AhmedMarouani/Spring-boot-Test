package com.example.Test.controller;


import com.example.Test.model.Client;
import com.example.Test.model.Commande;
import com.example.Test.service.ClientService;
import com.example.Test.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Commandes")
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping("/")
    public List<Commande> getAllCommandes() {
        List<Commande> Commandes = commandeService.getAllCommandes();
        return Commandes;
    }

    @GetMapping("/{id}")
    public Commande getCommandeByID(@PathVariable("id") Integer id) {
        Commande client = commandeService.getCommandeByID(id);
        return client;
    }

    @PostMapping("/addClient")
    public Commande addNewUCommande(@RequestBody Commande commande) {
        Commande commande1 = commandeService.addNewCommande(commande);
        return commande1;
    }
}
