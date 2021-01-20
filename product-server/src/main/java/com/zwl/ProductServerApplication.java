package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by zwl on 2020/11/24 18:52
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrix
//@EnableHystrixDashboard
public class ProductServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProductServerApplication.class);
  }

//  @Bean
//  @LoadBalanced
//  public RestTemplate restTemplate(){
//    RestTemplate template = new RestTemplate();
//    return template;
//  }
}
