package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/** Created by zwl on 2020/11/25 18:45 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class HystrixTurbineApplication {
  public static void main(String[] args) {
    SpringApplication.run(HystrixTurbineApplication.class, args);
  }
}
