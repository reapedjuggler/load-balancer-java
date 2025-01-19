package com.example.Load_Balancer.service.strategies.impl;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

public class WeightedStrategy implements LoadBalancerStrategy {
    @Override
    public Server nextServer(List<Server> servers) {
        if (CollectionUtils.isEmpty(servers)) {
            throw new RuntimeException("There are no running servers");
        }
        int totalWeight = servers.stream().mapToInt(Server::getWeight).sum();
        Random random = new Random();
        int nextWeight = random.nextInt(totalWeight);
        int currentWeight = 0;
        for (Server server : servers) {
            currentWeight += server.getWeight();
            if (currentWeight >= nextWeight) {
                return server;
            }
        }
        return servers.get(0);
    }
}
