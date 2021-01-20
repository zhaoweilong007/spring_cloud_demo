package com.zwl.feign;

import org.springframework.stereotype.Component;

/**
 * Created by zwl on 2020/11/25 14:59
 */
@Component
public class OrderServerClientCallBack implements OrderServerClient {
  /**
   * 熔断降级方法
   * @param name
   * @return
   */
  @Override
  public String getOrder(String name) {
    return "触发feign client 熔断降级方法";
  }
}
