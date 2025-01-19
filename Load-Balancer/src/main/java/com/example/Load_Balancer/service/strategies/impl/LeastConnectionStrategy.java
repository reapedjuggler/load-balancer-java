package com.example.Load_Balancer.service.strategies.impl;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class LeastConnectionStrategy implements LoadBalancerStrategy {
    @Override
    public Server nextServer(List<Server> servers) {
        if (CollectionUtils.isEmpty(servers)) {
            throw new RuntimeException("There are no running servers");
        }
        int minRequests = Integer.MAX_VALUE;
        Server target = servers.get(0);
        for (Server server : servers) {
            if (server.getRequests() < minRequests) {
                minRequests = server.getRequests();
                target = server;
            }
        }
        return target;
    }
}
