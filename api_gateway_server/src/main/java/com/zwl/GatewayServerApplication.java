package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zwl on 2020/11/26 12:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(GatewayServerApplication.class);
  }
}
