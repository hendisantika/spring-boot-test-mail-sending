package com.hendisantika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-mail-sending
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 6/22/22
 * Time: 06:55
 * To change this template use File | Settings | File Templates.
 */
@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NotificationControllerSecondIT {

    @Container
    static GenericContainer greenMailContainer = new GenericContainer<>(DockerImageName.parse("greenmail/standalone:1.6.1"))
            .waitingFor(Wait.forLogMessage(".*Starting GreenMail standalone.*", 1))
            .withEnv("GREENMAIL_OPTS", "-Dgreenmail.setup.test.smtp -Dgreenmail.hostname=0.0.0.0 -Dgreenmail.users=naruto:konoha")
            .withExposedPorts(3025);
    @Autowired
    private TestRestTemplate testRestTemplate;

    @DynamicPropertySource
    static void configureMailHost(DynamicPropertyRegistry registry) {
        registry.add("spring.mail.host", greenMailContainer::getHost);
        registry.add("spring.mail.port", greenMailContainer::getFirstMappedPort);
    }
}
