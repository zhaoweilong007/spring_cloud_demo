package com.zwl.filter.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/** Created by zwl on 2020/11/26 14:58 */
//@Configuration
public class KeyResolverConfiguration {

  /**
   * 基于请求路径的限流规则
   *
   * @return
   */
//  @Bean
  public KeyResolver pathKeyResolver() {
    return new KeyResolver() {
      /**
       * @param exchange 上下文对象
       * @return
       */
      @Override
      public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getPath().toString());
      }
    };
  }

  /**
   * 基于IP的限流
   * @return
   */
  @Bean
  public KeyResolver IpKeyResolver() {
    return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("X-Forwarded-For"));
  }
}
