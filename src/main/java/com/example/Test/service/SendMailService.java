package com.example.Test.service;

import com.example.Test.model.EmailRequest;

public interface SendMailService {
     String sendTextEmail(EmailRequest emailRequest);

}
