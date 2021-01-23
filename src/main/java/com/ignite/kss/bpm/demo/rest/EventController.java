package com.ignite.kss.bpm.demo.rest;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.kss.bpm.demo.dto.EmailParams;

@RestController
@RequestMapping("/event-dispatch")
public class EventController {
    private static Logger logger = LoggerFactory.getLogger(EventController.class);

    @GetMapping("/notifytimeout")
    String notifyTimeout(@RequestParam String processName, @RequestParam String currentAssignee ) {
        logger.info("=======================TIMEOUT-NOTIFICATION-START========================");
        logger.info("Instance of process {} is waiting with {} !! Please take action",processName,currentAssignee);
        logger.info("=======================TIMEOUT-NOTIFICATION-END==========================");
        return "NOTIFICATION DONE";
    }


    @PostMapping("/sendEmail")
    void sendEmail(@RequestBody EmailParams emailParams) {

        try {
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", emailParams.getHost());
            properties.put("mail.smtp.port", emailParams.getPort());
            properties.put("mail.smtp.ssl.enable", emailParams.getEnableSSl());
            properties.put("mail.smtp.auth", emailParams.getAuth());
            properties.put("mail.smtp.socketFactory.port", emailParams.getPort());
            properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailParams.getFrom(), emailParams.getPassword());
                }
            });
            session.setDebug(true);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailParams.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailParams.getTo()));
            message.setSubject(emailParams.getSubject());
            message.setText(emailParams.getMessageText());
            logger.info("sending...");
            Transport.send(message);
            logger.info("Sent message successfully....");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
