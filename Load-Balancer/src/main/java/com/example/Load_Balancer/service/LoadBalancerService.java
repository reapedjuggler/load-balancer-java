package com.example.Load_Balancer.service;

import com.example.Load_Balancer.model.Server;

public interface LoadBalancerService {
    void updateStrategy(String strategyName);

    void addServers(Server server);

    Server nextServer() throws Exception;
}
