package com.userprofile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;

@Configuration
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {
    @Override
    protected String nameSpace() {
        return "test";
    }

    @Override
    protected String hosts() {
        return "aerospike:3000"; // Host and port
    }
}