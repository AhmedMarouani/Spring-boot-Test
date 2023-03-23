package com.example.Test.component;

import com.example.Test.model.Client;
import com.example.Test.model.Commande;
import com.example.Test.model.EmailRequest;
import com.example.Test.model.Produit;
import com.example.Test.repository.ClientRepository;
import com.example.Test.repository.CommandeRepository;
import com.example.Test.repository.ProduitRepository;
import com.example.Test.service.SendMailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Component
@AllArgsConstructor
public class ScheduledTasks {
    private ProduitRepository produitRepository;
    private SendMailService sendMailService;
    private CommandeRepository commandeRepository;


    @Scheduled(fixedRate = 5000)
    public void sendMailOnCommande() {
        List<Commande> commandes = commandeRepository.findAll();
        for (Commande commande : commandes) {
            EmailRequest emailRequest = new EmailRequest();
            emailRequest.setTo(commande.getClient().getEmail());
            emailRequest.setSubject("New Commande added");
            emailRequest.setText("Dear " + commande.getClient().getNom() + ",\n\nA new Commande has been added with ID " + commande.getId() + ".");
            sendMailService.sendTextEmail(emailRequest);
        }
    }
}






