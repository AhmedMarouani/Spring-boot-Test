package com.example.Test.service;

import com.example.Test.model.Client;
import com.example.Test.model.Produit;
import com.example.Test.repository.ProduitRepository;
import com.example.Test.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProduitServiceImpl implements ProduitService{

    @Autowired
    private ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitByID(Integer id) {
        return produitRepository.findById(id).orElseThrow();
    }

    @Override
    public Produit addNewProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public ResponseEntity<MessageResponse> updateProduitByID(Integer id, Produit produit) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isPresent()) {
            Produit editedProduit = optionalProduit.get();

            editedProduit.setNom(produit.getNom());
            editedProduit.setDescription(produit.getDescription());
            editedProduit.setQuantité(produit.getQuantité());
            editedProduit.setPrix(produit.getPrix());
            editedProduit.setCommande(produit.getCommande());

            produitRepository.save(editedProduit);
            MessageResponse messageResponse = new MessageResponse("Produit edited successfully");

            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @Override
    public ResponseEntity<MessageResponse> deleteProduitById(Integer id) {
        Optional<Produit> optionalProduit = produitRepository.findById(id);
        if (optionalProduit.isPresent()) {
            produitRepository.deleteById(id);
            MessageResponse messageResponse = new MessageResponse("Produit deleted successfully");
            return ResponseEntity.ok(messageResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
