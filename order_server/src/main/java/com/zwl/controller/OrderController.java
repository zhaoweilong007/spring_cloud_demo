package com.zwl.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/** Created by zwl on 2020/11/24 16:59 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

  @GetMapping("/{name}")
  public String get(@PathVariable("name") String name) {

    return "hello world " + name;
  }

  @GetMapping("query/{id}")
  public String getId(@PathVariable("id") String id) {
    return "查询id数据：" + id;
  }

  @PostMapping
  public Map<String, Object> add() {
    Map<String, Object> map = new HashMap<>();
    map.put("code", 200);
    map.put("msg", "success");
    map.put("data", null);
    return map;
  }
}
