package it.jdk.demokafkaconsumer.model;

import lombok.Data;

/**
 * Test model shared with kafka-producer
 */
@Data
public class TestOne {

    private String testString;
    private String testCode;

    public TestOne() {}

}
