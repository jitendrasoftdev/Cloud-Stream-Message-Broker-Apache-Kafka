package com.jsd.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApplication {
    
    private Logger log = LoggerFactory.getLogger(ConsumerApplication.class);
    
    @StreamListener("input")
    private void consumeMessage(Book book) {
        log.info("Consumer payload : " + book);
    }

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

}
