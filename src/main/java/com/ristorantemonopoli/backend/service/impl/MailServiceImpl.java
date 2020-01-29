package com.ristorantemonopoli.backend.service.impl;

import com.ristorantemonopoli.backend.service.MailService;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    @Override
    public void sendMail(List<String> recipients, String subject, String content) throws Exception {
// Sender's email ID needs to be mentioned
        String from = "info@ristorantemonopoli.com";
        final String username = "AKIA2QW6NI57B7HGWN7Q";//change accordingly
        final String password = "BLa4xu+cm8KyTAAUlwsQ6x6EtAAUeArvJN1yvOotjxTb";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "email-smtp.eu-west-1.amazonaws.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(from));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(String.join(",", recipients)));

        // Set Subject: header field
        message.setSubject(subject);

        // Send the actual HTML message, as big as you like
        message.setContent(
                content,
                "text/html");

        // Send message
        Transport.send(message);

        System.out.println("Sent message successfully....");
    }
}
