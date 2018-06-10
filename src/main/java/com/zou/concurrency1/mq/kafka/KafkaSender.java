package com.zou.concurrency1.mq.kafka;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
public class KafkaSender {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;
    private Gson gson = new GsonBuilder().create();

    private void send(String msg) {

        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());

        System.out.println("Message: " + message);

        kafkaTemplate.send(TopicConstants.TEST, gson.toJson(message));

    }


}





















