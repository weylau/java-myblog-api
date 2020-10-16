package com.weylau.javamyblogapi.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaConsumer {
//    @KafkaListener(topics = "test_topic", groupId = "test_topic" , concurrency="3")
//    public void listen(String msgData, Acknowledgment ark) throws InterruptedException {
//        log.info("demo receive : "+msgData);
////        Thread.sleep(6000L);
//        ark.acknowledge();
//    }
}
