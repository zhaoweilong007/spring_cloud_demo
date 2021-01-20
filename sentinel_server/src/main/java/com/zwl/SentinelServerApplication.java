package com.zwl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zwl.util.ExceptionUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/** Created by zwl on 2020/11/25 20:05 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class SentinelServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(SentinelServerApplication.class);
  }

  /**
   * 对所有的请求降价
   * @return
   */
//  @SentinelResource(blockHandlerClass = ExceptionUtils.class,fallbackClass = ExceptionUtils.class,
//      fallback = "handlerFallBack",blockHandler = "handlerBlock")
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
