package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/** Created by zwl on 2020/11/26 11:34 */
@SpringBootApplication
//@EnableZuulServer
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(ZuulServerApplication.class);
  }
}
