package com.zwl.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/** Created by zwl on 2020/11/26 13:33  全局过滤器*/
//@Component
public class LoginFilter implements GlobalFilter, Ordered {
  /**
   * 执行过滤器的业务逻辑
   *
   * @param exchange 请求的上下文对象
   * @param chain
   * @return
   */
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    System.out.println("执行自定义全局过滤器");
    ServerHttpRequest request = exchange.getRequest();
    String access_token = request.getQueryParams().getFirst("access_token");
    if (access_token == null) {
      System.out.println("===========认证失败=======");
      exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
      return exchange.getResponse().setComplete();
    }
    return chain.filter(exchange);
  }

  /**
   * 指定过滤器的执行顺序
   *
   * @return
   */
  @Override
  public int getOrder() {
    return 1;
  }
}
