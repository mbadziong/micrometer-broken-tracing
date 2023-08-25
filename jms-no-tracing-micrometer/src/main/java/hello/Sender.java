package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sender {
    private static Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void send() {
        logger.info("sending message...");
        jmsTemplate.convertAndSend("test-queue", "hello");
    }
}
