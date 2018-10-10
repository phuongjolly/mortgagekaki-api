package com.mortgagekaki.loanapi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    /**
     * the rest template
     */
    private final JavaMailSender mailSender;

    private final String fromAddress;

    private final String ccAddress;

    public EmailService(JavaMailSender mailSender,
                        @Value("${email.from-address}") String fromAddress,
                        @Value("${email.cc-address}") String ccAddress) {
        this.mailSender = mailSender;
        this.ccAddress = ccAddress;
        this.fromAddress = fromAddress;
    }


    /**
     * Send an email using mail gun api
     * @param to the to address
     * @param subject the subject
     * @param body the body
     */
    public void sendEmail(
            String to,
            String subject,
            String body
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromAddress);
        message.setCc(ccAddress);

        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
