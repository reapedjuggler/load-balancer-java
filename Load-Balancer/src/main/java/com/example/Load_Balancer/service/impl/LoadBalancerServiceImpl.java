package com.example.Load_Balancer.service.impl;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.LoadBalancerService;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import com.example.Load_Balancer.service.strategies.impl.HashBasedStrategy;
import com.example.Load_Balancer.service.strategies.impl.LeastConnectionStrategy;
import com.example.Load_Balancer.service.strategies.impl.RoundRobinStrategy;
import com.example.Load_Balancer.service.strategies.impl.WeightedStrategy;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancerServiceImpl implements LoadBalancerService {

    private final List<Server> servers = new ArrayList<>();
    private LoadBalancerStrategy loadBalancerStrategy = new RoundRobinStrategy();

    @Override
    public void updateStrategy(String strategyName) {
        LoadBalancerStrategy loadBalancerStrategy = null;
        switch (strategyName.toLowerCase()) {
            case "round-robin":
                loadBalancerStrategy = new RoundRobinStrategy();
                break;
            case "least-connections":
                loadBalancerStrategy = new LeastConnectionStrategy();
                break;
            case "weighted":
                loadBalancerStrategy = new WeightedStrategy();
                break;
            case "hash-based":
                loadBalancerStrategy = new HashBasedStrategy();
                break;
            default:
                throw new RuntimeException("Invalid strategy name");
        }
        this.loadBalancerStrategy = loadBalancerStrategy;
    }

    @Override
    public void addServers(Server server) {
        servers.add(server);
    }

    @Override
    public Server nextServer() throws Exception {
        return loadBalancerStrategy.nextServer(servers);
    }
}
