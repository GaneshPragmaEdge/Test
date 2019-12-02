package com.mits.admindao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Office365Mail {

public static void mailSend(String from, String to) {

// create an object of properties

Properties properties = new Properties();

// set the property to the properties

// MAIL_TRANSPORT_PROTOCAL_KEY =mail.transport.protocol
// MAIL_SMTP_HOST_KEY =mail.smtp.host
// MAIL_SMTP_AUTH_KEY =mail.smtp.auth
// MAIL_SMTP_PORT_KEY =mail.smtp.port
//
// MAIL_TRANSPORT_PROTOCAL_VALUE=smtp
// MAIL_SMTP_HOST_VALUE=smtp.office365.com
// MAIL_SMTP_AUTH_VALUE=true
// MAIL_SMTP_PORT_VALUE=587
// SMTP_AUTH_USER = demo@mitsind.com
// SMTP_AUTH_PWD = monarch1@
// MAIL_SMTP_ENCRYPTION_KEY=mail.smtp.starttls.enable
// MAIL_SMTP_ENCRYPTION_VALUE=true
// MAIL_SMTP_SSL_TRUST=mail.smtp.ssl.trust

properties.put("mail.transport.protocol", "smtp");

properties.put("mail.smtp.host", "smtp.Office365.com");

properties.put("mail.smtp.port", "587");

properties.put("mail.smtp.auth", "true");

properties.put("mail.smtp.starttls.enable", true);

properties.put("mail.smtp.ssl.trust", "*");

Session session = Session.getInstance(properties,

new javax.mail.Authenticator() {

protected PasswordAuthentication getPasswordAuthentication() {

System.out.println("hello");

return new PasswordAuthentication("mitsind650@mitsind.com", "mits@1994");

}

});

try {
MimeMessage message = new MimeMessage(session);

message.setFrom(new InternetAddress(from));

String recipient = to;

String[] recipientList = recipient.split(",");

InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];

int counter = 0;

for (String recipient1 : recipientList) {

recipientAddress[counter] = new InternetAddress(recipient1.trim());

counter++;

}
message.setRecipients(Message.RecipientType.TO, recipientAddress);

message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

message.setSubject("Mail Test");

message.setText("event performed");
try {
Transport.send(message);

System.out.println("message sent successfully...");
} catch (Exception e) {

System.out.println("Error in email ::::: " + e.getMessage());
System.out.println("Error in email ::::: " + e.getMessage());
e.printStackTrace();

}

System.out.println("Testing::::::::::::::::::::;;");

}

catch (MessagingException e) {

e.printStackTrace();
}

}

public static void main(String[] args) {

Office365Mail.mailSend("mitsind650@mitsind.com", "mitsind650@mitsind.com");

}
}

