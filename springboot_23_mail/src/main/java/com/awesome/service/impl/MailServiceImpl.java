package com.awesome.service.impl;

import com.awesome.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    private String sender = "hidden@hidden.com";
    private String receiver = "hidden2@hidden2.com";
    private String subject = "test";
    private String content = "<a href='https://www.google.com'>Surprise!</a>";

    @Override
    public void send() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender + "(eee)");
            helper.setTo(receiver);
            helper.setSubject(subject);
            helper.setText(content, true);

            String pathname = "D:\\IdeaProjects\\SpringBootProj\\springboot\\server.2022-05-04.0.log";
            File file = new File(pathname);

            helper.addAttachment(file.getName(), file);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
