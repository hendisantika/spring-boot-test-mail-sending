package com.hendisantika;

import lombok.RequiredArgsConstructor;
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
}
