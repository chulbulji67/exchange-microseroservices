package com.example.currencyexchangeservice;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


//resilience4j.retry.instances.sample-api.maxAttempts=5
@RestController
public class CircuitBreakerController {

    private Logger logger =  LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
    @Retry(name = "default")
    public String sampleApi(){
        logger.info("Sample api call received");
        new RestTemplate().getForEntity("http://localhost:8080/some-dummy",String.class);

        return "sample aApi";
    }
}
