package com.example.Test.repository;

import com.example.Test.model.Client;
import com.example.Test.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
