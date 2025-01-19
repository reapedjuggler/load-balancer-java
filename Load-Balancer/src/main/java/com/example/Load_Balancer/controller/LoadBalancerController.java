package com.example.Load_Balancer.controller;

import com.example.Load_Balancer.model.Server;
import com.example.Load_Balancer.service.LoadBalancerService;
import com.example.Load_Balancer.service.impl.LoadBalancerServiceImpl;
import com.example.Load_Balancer.service.strategies.LoadBalancerStrategy;
import com.example.Load_Balancer.service.strategies.impl.RoundRobinStrategy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/load-balancer")
public class LoadBalancerController {
    private final LoadBalancerStrategy strategy = new RoundRobinStrategy(); // Default
    private final LoadBalancerService loadBalancerService = new LoadBalancerServiceImpl();

    @PostMapping("/add-server")
    public ResponseEntity<Object> addServer(@RequestBody Server server) {
        loadBalancerService.addServers(server);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/set-strategy")
    public ResponseEntity<Object> setStrategy(@RequestParam String strategyName) {
        loadBalancerService.updateStrategy(strategyName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-next-server")
    public Server getNextServer() throws Exception {
        return loadBalancerService.nextServer();
    }
}
