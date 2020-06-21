package tech.donau.course.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import tech.donau.course.config.Base64Value;
import tech.donau.course.config.GreetingConfig;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class GreetingService {

    @Inject
    GreetingConfig greetingConfig;

    @ConfigProperty(name = "greeting.base64greet")
    Base64Value base64greet;

    public String sayHello(String name) {
        return String.format("Hello %s, your ID is %s.", name, UUID.randomUUID().toString());
    }

    public String sayHello() {
        return greetingConfig.getPrefix().orElse("_")
                + base64greet
                + greetingConfig.getSuffix()
                + "Your country is " + greetingConfig.getCountry().getName()
                + "(" + greetingConfig.getCountry().getId() + ").";
    }
}
