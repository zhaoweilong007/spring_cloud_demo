package com.zwl.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/** Created by zwl on 2020/11/27 16:01 */
@EnableBinding({Sink.class})
@Component
@Slf4j
public class MessageListener {

  @StreamListener(Sink.INPUT)
  public void input(String message) {
    log.info("收到消息：{}",message);
  }
}
