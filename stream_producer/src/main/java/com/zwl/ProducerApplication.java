package com.zwl;

import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

/** Created by zwl on 2020/11/27 14:38 */
@EnableBinding(Source.class)
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

  @Autowired MessageChannel output;

  public static void main(String[] args) {
    SpringApplication.run(ProducerApplication.class);
  }

  @Override
  public void run(String... args) throws Exception {
    Map<String, Object> map = new HashMap<>();
    map.put(MessageConst.PROPERTY_TAGS, "tagA");
    Boolean send =
        output.send(MessageBuilder.createMessage("hello world stream", new MessageHeaders(map)));
    //    boolean send = output.send(MessageBuilder.withPayload("hello world").build());
    System.out.println("消息发送结果：" + send);
  }
}
