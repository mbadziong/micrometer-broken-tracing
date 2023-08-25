package hello;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static Logger logger = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "test-queue")
//    @Observed
    public void receive(String s) {
        logger.info("received message: {}", s);
    }
}
