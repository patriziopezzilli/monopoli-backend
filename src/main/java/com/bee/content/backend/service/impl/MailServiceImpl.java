package com.bee.content.backend.service.impl;

import com.bee.content.backend.service.MailService;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    private Properties props = new Properties();
    private String from;
    private String username;
    private String password;

    @PostConstruct
    private void init() {
        String host = "email-smtp.eu-west-1.amazonaws.com";

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        from = "info@ristorantemonopoli.com";
        username = "AKIA2QW6NI57B7HGWN7Q";//change accordingly
        password = "BLa4xu+cm8KyTAAUlwsQ6x6EtAAUeArvJN1yvOotjxTb";//change accordingly
    }

    @Override
    public void sendMail(List<String> recipients, String subject, String content, String merchant) throws Exception {

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

    @Override
    public void sendMailWithAttachment(List<String> recipients, String subject, String content, String contentAttachment, String merchant) throws AddressException, Exception {
        ByteArrayOutputStream outputStream = null;

        try {
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            //construct the text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(content);

            //now write the PDF content to the output stream
            outputStream = new ByteArrayOutputStream();
            writePdf(subject, getByteArray(contentAttachment));
            byte[] bytes = outputStream.toByteArray();

            //construct the pdf body part
            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
            MimeBodyPart pdfBodyPart = new MimeBodyPart();
            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
            pdfBodyPart.setFileName("menudelgiorno.pdf");

            //construct the mime multi part
            MimeMultipart mimeMultipart = new MimeMultipart();
            mimeMultipart.addBodyPart(textBodyPart);
            mimeMultipart.addBodyPart(pdfBodyPart);

            //create the sender/recipient addresses
            InternetAddress iaSender = new InternetAddress(from);

            //construct the mime message
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setSender(iaSender);
            mimeMessage.setSubject(subject);
            mimeMessage.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(String.join(",", recipients)));
            mimeMessage.setContent(mimeMultipart);

            //send off the email
            Transport.send(mimeMessage);

            System.out.println("Sent message successfully....");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //clean off
            if (null != outputStream) {
                try {
                    outputStream.close();
                    outputStream = null;
                } catch (Exception ex) {
                }
            }
        }
    }

    public ByteArrayOutputStream getByteArray(String data) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArrayOutputStream);

        try {
            out.write(data.getBytes());
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }

    public void writePdf(String title, OutputStream outputStream) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);

        document.open();

        document.addTitle(title);
        document.addSubject(title);
        document.addKeywords("ristorante, monopoli, menù");
        document.addAuthor("Ristorante Monopoli");
        document.addCreator("www.ristorantemonopoli.com");

        document.close();
    }
}
