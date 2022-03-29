package at2.ivanov.nikita.events.service;

import at2.ivanov.nikita.events.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class EmailService {
    private final JavaMailSenderImpl javaMailSender;

    public void sendMessages(Set<User> usersToSend, String subject, String text) {
        String from = javaMailSender.getUsername();
        Set<SimpleMailMessage> messages = new HashSet<>();

        for (User user : usersToSend) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(user.getEmail());
            message.setSubject(subject);
            message.setText(text);
            messages.add(message);
        }
        javaMailSender.send(messages.toArray(new SimpleMailMessage[0]));
    }

    public void sendMessageToUser(User user, String subject, String text) {
        String from = javaMailSender.getUsername();
        sendMessage(from, user.getEmail(), subject, text);
    }

    public void sendMessageToHost(String subject, String text) {
        String host = javaMailSender.getUsername();
        sendMessage(host, host, subject, text);
    }

    public void sendMessage(String from, String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
