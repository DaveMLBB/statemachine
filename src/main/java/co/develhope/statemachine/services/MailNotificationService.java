package co.develhope.statemachine.services;

import co.develhope.statemachine.models.User;

public interface MailNotificationService {
    void sendActivationEmail(User user);
}
