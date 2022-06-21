package com.hendisantika;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-mail-sending
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/22/22
 * Time: 06:52
 * To change this template use File | Settings | File Templates.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JavaMailSenderPerMethodIT {

    @RegisterExtension
    static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP)
            .withConfiguration(GreenMailConfiguration.aConfig().withUser("duke", "springboot"))
            .withPerMethodLifecycle(true);

    @Autowired
    private JavaMailSender javaMailSender;

    @Test
    void verifyDeliveryToGreenMailServer() {
        sendEmailAndVerify();
    }

    @Test
    void verifyDeliveryToGreenMailServerSecond() {
        sendEmailAndVerify();
    }
}
