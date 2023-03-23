package com.example.Test.controller;

import com.example.Test.model.Produit;
import com.example.Test.response.MessageResponse;
import com.example.Test.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/")
    public List<Produit> getAllProduits() {
        List<Produit> produits = produitService.getAllProduits();
        return produits;
    }

    @GetMapping("/{id}")
    public Produit getProduitByID(@PathVariable("id") Integer id) {
        Produit produit = produitService.getProduitByID(id);
        return produit;
    }

    @PostMapping("/addProduit")
    public Produit addNewProduit(@RequestBody Produit produit) {
        Produit produit1 = produitService.addNewProduit(produit);
        return produit1;
    }

    @PutMapping("/editProduit/{id}")
    public ResponseEntity<MessageResponse> updateProduitByID(@PathVariable("id") Integer id, @RequestBody Produit produit) {
        ResponseEntity<MessageResponse> response = produitService.updateProduitByID(id, produit);
        return response;
    }

    @DeleteMapping("/deleteProduit/{id}")
    public ResponseEntity<MessageResponse> deleteProduitById(@PathVariable("id") Integer id) {
        ResponseEntity<MessageResponse> response = produitService.deleteProduitById(id);
        return response;
    }

}


