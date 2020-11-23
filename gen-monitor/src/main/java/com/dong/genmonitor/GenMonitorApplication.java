package com.dong.genmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer  // 监听服务
public class GenMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenMonitorApplication.class, args);
    }

}
