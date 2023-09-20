package it.jdk.demokafkaproducer.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Topic configuration class
 */
@Configuration
public class TopicConfig {

    /**
     * Kafka-zookeeper broker IP address
     */
    @Value(value = "127.0.0.1:9092")
    private String boostrapAddress;

    /**
     * Administer the Kafka infrastructure, mainly taking care about availability, performance, security and automation
     * @return configured kafka admin bean
     */
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                boostrapAddress);

        return new KafkaAdmin(configs);
    }

    /**
     * Topic bean generated via a builder with the specified configuration
     * @return topic instance
     */
    @Bean
    public NewTopic topicOne() {
        return TopicBuilder.name("topicOne")
                .partitions(1)
                .replicas(1).build();
//        return new NewTopic("testOne", 1, (short) 1);
    }

    /**
     * Same as above
     * @return topic instance
     */
    @Bean
    public NewTopic topicTwo() {
        return TopicBuilder.name("topicTwo")
                .partitions(2)
                .replicas(1).build();
//        return new NewTopic("testTwo", 2, (short) 1);
    }
}
