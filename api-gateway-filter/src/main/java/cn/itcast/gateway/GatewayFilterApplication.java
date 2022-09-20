package cn.itcast.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayFilterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class,args);
    }
}
