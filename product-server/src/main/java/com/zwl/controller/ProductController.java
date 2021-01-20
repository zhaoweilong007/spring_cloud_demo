package com.zwl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zwl.feign.OrderServerClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/** Created by zwl on 2020/11/24 18:54 */
@RestController
@Slf4j
@RequestMapping("/product")
@DefaultProperties(defaultFallback = "defaultFallBack")
public class ProductController {

  @Autowired DiscoveryClient discoveryClient;

  @Autowired OrderServerClient serverClient;

  //  @Autowired RestTemplate restTemplate;

//  @HystrixCommand(fallbackMethod = "productServerFallBack")
  @HystrixCommand
  @GetMapping("/{name}")
  public String productServer(@PathVariable String name) {

//    List<ServiceInstance> instances = discoveryClient.getInstances("order-server");
//    ServiceInstance instance = instances.get(0);

    //    restTemplate.postForObject("http://"+instance.getHost()+instance.get, )

    //    return
    // restTemplate.postForEntity("http://"+instance.getHost()+":"+instance.getPort()+"/order",
    // "",String.class);
    //    return  restTemplate.postForEntity("http://order-server/order", "",String.class);
    return serverClient.getOrder(name);
  }

  public String productServerFallBack(String name) {
    return "触发熔断降级";
  }

  /**
   * 统一的降级方法
   * 没有参数
   */
  public String defaultFallBack(){
    log.warn("触发公共的降级方法");

    return "触发公共的降级方法";
  }


  @GetMapping("/id")
  public String getById() {
    return "hello world";
  }
}
