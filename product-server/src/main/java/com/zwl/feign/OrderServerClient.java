package com.zwl.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Created by zwl on 2020/11/25 12:42
 */
@Component
@FeignClient(name = "order-server",fallback =OrderServerClientCallBack.class )
public interface OrderServerClient {
  @GetMapping(value = "/order/{name}")
   String getOrder(@PathVariable("name") String name);
}
