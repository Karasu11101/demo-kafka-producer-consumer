package it.jdk.demokafkaproducer.config;

import it.jdk.demokafkaproducer.model.TestOne;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    /**
     * Kafka template bean
     * @return a new kafka template via producerFactory method
     */
    @Bean
    public KafkaTemplate<String, TestOne> kafkaTemplate() {
        return new KafkaTemplate<String, TestOne>(producerFactory());
    }

    /**
     * Builds a consumer class, which is an API that allows application to receive messages
     * @return a default consumer with the specified configuration
     */
    @Bean
    public ProducerFactory<String, TestOne> producerFactory() {

        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }
}
