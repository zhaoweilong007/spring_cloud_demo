package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by zwl on 2020/11/24 16:58
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableDiscoveryClient
public class OrderServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(OrderServerApplication.class);
  }
}
