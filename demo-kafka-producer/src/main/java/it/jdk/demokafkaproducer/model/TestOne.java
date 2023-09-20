package it.jdk.demokafkaproducer.model;

import lombok.Data;

/**
 * Model class for topics produced by the producer
 */
@Data
public class TestOne {

    private String testString;
    private String testCode;

    public TestOne() {}

}
