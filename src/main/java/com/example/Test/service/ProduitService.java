package com.example.Test.service;

import com.example.Test.model.Client;
import com.example.Test.model.Produit;
import com.example.Test.response.MessageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProduitService {

    List<Produit> getAllProduits();

    Produit getProduitByID(Integer id);

    Produit addNewProduit(Produit produit);

    ResponseEntity<MessageResponse> updateProduitByID(Integer id, Produit produit);

    ResponseEntity<MessageResponse> deleteProduitById(Integer id);
}
