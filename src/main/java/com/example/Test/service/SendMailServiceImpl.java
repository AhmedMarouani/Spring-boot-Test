package com.example.Test.service;

import com.example.Test.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService{

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendTextEmail(EmailRequest emailRequest) {
        //receives the emailrequest as parameters and sets its properties in the SimpleMailMessage class then sends
        // them using JavaMail Sender
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getText());
        javaMailSender.send(message);
        return "Email sent successfully";
    }


}
