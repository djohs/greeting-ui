package io.pivotal.fortune;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FortuneService {

    private final RestTemplate restTemplate;
    Logger logger = LoggerFactory
            .getLogger(FortuneService.class);

    public FortuneService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getFortune() {
        String fortune = restTemplate.getForObject("http://fortune-service", String.class);
        return fortune;
    }

    public String defaultFortune() {
        logger.debug("Default fortune used.");
        return "This fortune is no good. Try another.";
    }

}
