package co.develhope.statemachine.services.impl;

import co.develhope.statemachine.models.User;
import co.develhope.statemachine.services.MailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailNotificationServiceImpl implements MailNotificationService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendActivationEmail(User user) {

        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(user.getEmail());
        sms.setFrom("devtestdevtest828117@tiscali.it");
        sms.setReplyTo("devtestdevtest828117@tiscali.it");
        sms.setSubject("ti sei iscritto al login demo");
        sms.setText("il codice di attivazione è:" + user.getActivationCode());
        javaMailSender.send(sms);

    }
}
