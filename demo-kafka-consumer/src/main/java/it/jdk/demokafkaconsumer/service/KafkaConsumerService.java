package it.jdk.demokafkaconsumer.service;

import it.jdk.demokafkaconsumer.model.TestOne;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {

    /**
     * Service that listens to events from the kafka-producer application
     * @param message the contents of TestOne class received from kafka-producer application
     */
    @KafkaListener(topics = {"topicOne", "topicTwo"}, groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    //TODO fix SerializationException (configure an 'ErrorHandlingDeserializer'?)
//    @KafkaListener(topics = {"topicOne", "topicTwo"}, groupId = "group_json", containerFactory = "testKafkaListenerFactory")
//    public void listenWithHeaders(
//            @Payload TestOne message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
//        System.out.println("Received message: \n" + message + "\nfrom partition: " + partition);
//    }
}
