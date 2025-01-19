package com.example.Load_Balancer.service.strategies.impl;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.zip.CRC32;

public class HashBasedStrategy implements LoadBalancerStrategy {
    private static final Logger log = LoggerFactory.getLogger(HashBasedStrategy.class);

    @Override
    public Server nextServer(List<Server> servers) {
        if (CollectionUtils.isEmpty(servers)) {
            log.error("[HashBasedStrategy : nextServer] - There are no running servers");
            throw new RuntimeException("There are no running servers");
        }
        return getServerFromHash(servers);
    }

    // Hashing algorithm to get the server from the hash.
    public Server getServerFromHash(List<Server> serverList) {
        CRC32 hash = new CRC32();
        for (Server server : serverList) {
            hash.update(server.getName().getBytes());
        }
        int hashValue = (int) (hash.getValue() % serverList.size());
        return serverList.get(hashValue);
    }
}
