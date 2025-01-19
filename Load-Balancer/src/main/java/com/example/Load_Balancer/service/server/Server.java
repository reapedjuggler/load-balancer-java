package com.example.Load_Balancer.service.server;

import com.example.Load_Balancer.model.commons.ServerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Server {
    private String serverName;
    private String serverIp;
    private int serverConnections;
    private int serverWeight;
    // defines the port on which the server is running currently.
    private int port;
    private ServerStatus serverStatus;
}
