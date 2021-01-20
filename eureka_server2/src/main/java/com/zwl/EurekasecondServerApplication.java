package com.zwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by zwl on 2020/11/24 19:37
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekasecondServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(EurekasecondServerApplication.class);
  }
}
