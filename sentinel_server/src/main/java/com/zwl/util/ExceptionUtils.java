package com.zwl.util;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

import java.util.HashMap;

/** Created by zwl on 2020/11/25 21:09 */
public class ExceptionUtils {

  private static ObjectMapper objectMapper = new ObjectMapper();

  /**
   * 限流熔断业务逻辑
   * @param request
   * @param body
   * @param execution
   * @param exception
   * @return
   * @throws JsonProcessingException
   */
  public static SentinelClientHttpResponse handlerBlock(
      HttpRequest request,
      byte[] body,
      ClientHttpRequestExecution execution,
      BlockException exception) throws JsonProcessingException {

    HashMap<Object, Object> map = new HashMap<>();
    map.put("code", 500);
    map.put("msg", "block");

    return new SentinelClientHttpResponse(objectMapper.writeValueAsString(map));
  }


  /**
   * 异常熔断业务逻辑
   * @param request
   * @param body
   * @param execution
   * @param exception
   * @return
   * @throws JsonProcessingException
   */
  public static SentinelClientHttpResponse handlerFallBack(
      HttpRequest request,
      byte[] body,
      ClientHttpRequestExecution execution,
      BlockException exception) throws JsonProcessingException {

    HashMap<Object, Object> map = new HashMap<>();
    map.put("code", 500);
    map.put("msg", "fallback");

    return new SentinelClientHttpResponse(objectMapper.writeValueAsString(map));
  }
}
