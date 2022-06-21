package com.hendisantika;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-mail-sending
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/22/22
 * Time: 06:35
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final JavaMailSender javaMailSender;

    public void notifyUser(String email, String content) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("admin@spring.io");
        mail.setSubject("A new message for you");
        mail.setText(content);
        mail.setTo(email);

        this.javaMailSender.send(mail);
    }
}
