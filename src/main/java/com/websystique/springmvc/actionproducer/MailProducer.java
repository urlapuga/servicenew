package com.websystique.springmvc.actionproducer;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailProducer {
    public static boolean send(String to, String emailSubject, String emailMessage) {

        final String username = "urlapuga@gmail.com";
        final String password = "yjdsqgfhjkm";

        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(emailSubject);
            message.setText(emailMessage);

            Transport.send(message);

            return true;

        } catch (MessagingException e) {

            return false;
        }
    }
}
