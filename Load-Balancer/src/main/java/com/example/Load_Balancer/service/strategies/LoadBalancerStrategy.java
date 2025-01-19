package com.example.Load_Balancer.service.strategies;

import com.example.Load_Balancer.model.Server;

import java.util.List;

public interface LoadBalancerStrategy {
    Server nextServer(List<Server> servers) throws Exception;
}