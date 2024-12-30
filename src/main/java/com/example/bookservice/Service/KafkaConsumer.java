package com.example.bookservice.Service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "book-topic", groupId = "book-group")
    public void consume(String message) {
        log.info("Получено сообщение из кафки :" + message);
    }

}
