package it.jdk.demokafkaproducer.controller;

import it.jdk.demokafkaproducer.model.TestOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class ProducerController {

    /**
     * A wrapper for the producer that should ease dependency injection and automatic configuration
     */
    private final KafkaTemplate<String, TestOne> kafkaTemplate;
//    private static final String TOPIC1 = "topic1";
//    private static final String TOPIC2 = "topic2";

    @Autowired
    public ProducerController(KafkaTemplate<String, TestOne> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Endpoint for topics
     * @param topicName identifier for the topic
     * @param message contents of TestOne 'message' field
     * @return String containing general success message
     */
    @PostMapping("/publish/{topicName}/{message}")
    public String postMessage(@PathVariable("topicName") final String topicName,
                              @PathVariable("message") final String message) {
        TestOne testOne = new TestOne();
        testOne.setTestString(message);
        if(topicName.equals("topicOne")) {
            testOne.setTestCode("0001");
        } else
            testOne.setTestCode("0002");

        kafkaTemplate.send(topicName, testOne);
        return "Topic successfully posted";
    }

//    @PostMapping("/publish2/{topicName}/{message}")
//    public String postMessage2(@PathVariable("topicName") final String topicName,
//                               @PathVariable("message") final String message) {
//        TestOne testOne = new TestOne();
//        testOne.setTestString(message);
//        testOne.setTestCode("0002");
//        kafkaTemplate.send(topicName, testOne);
//
//        return "topicTwo successfully posted";
//    }
}
