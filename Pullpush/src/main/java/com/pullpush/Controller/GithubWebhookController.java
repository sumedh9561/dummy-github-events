package com.pullpush.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class GithubWebhookController {

    private static final Logger logger = LoggerFactory.getLogger(GithubWebhookController.class);

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody String payload) {
        // Parse the JSON payload and log the details of the event
        logger.info("Received Github webhook event: {}", payload);
    }
}
