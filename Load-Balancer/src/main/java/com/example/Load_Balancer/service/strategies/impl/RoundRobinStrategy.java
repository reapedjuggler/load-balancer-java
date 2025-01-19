package com.example.Load_Balancer.service.strategies.impl;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class RoundRobinStrategy implements LoadBalancerStrategy {
    private int currentIndex = 0;
    @Override
    public Server nextServer(List<Server> servers) throws Exception {
        if (CollectionUtils.isEmpty(servers)) {
            throw new Exception("There are no running servers");
        }
        return servers.get(currentIndex++);
    }
}
