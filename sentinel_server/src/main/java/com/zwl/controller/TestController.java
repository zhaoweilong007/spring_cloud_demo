package com.zwl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/** Created by zwl on 2020/11/25 20:08 */
@RestController
public class TestController {

  @Autowired private RestTemplate restTemplate;

  /**
   * blockHandler: 触发熔断降级的方法
   * fallback：触发异常降级的方法
   * @param id
   * @return
   */
//  @SentinelResource(blockHandler = "blockHandler",fallback = "fallBack")
  @GetMapping("test/{id}")
  public String queryById(@PathVariable("id") String id) {
    if (!id.equals("1")) {
      throw new RuntimeException("错误");
    }
    String forObject = restTemplate.getForObject("http://localhost:9001/order/query/" + id, String.class);

    return forObject;
  }

  public String blockHandler(String id) {
    return "触发熔断的降级方法";
  }

  public String fallBack(String id) {
    return "触发异常的降级方法";
  }
}
