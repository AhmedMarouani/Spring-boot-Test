package com.example.Test.repository;

import com.example.Test.model.Client;
import com.example.Test.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
