package com.weylau.javamyblogapi.service.front.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rabbitmq.client.Channel;
import com.weylau.javamyblogapi.config.rabbitmq.RabbitConfig;
import com.weylau.javamyblogapi.entity.Articles;
import com.weylau.javamyblogapi.entity.ArticlesContents;
import com.weylau.javamyblogapi.entity.ArticlesContentsExample;
import com.weylau.javamyblogapi.entity.ArticlesExample;
import com.weylau.javamyblogapi.exception.MyblogException;
import com.weylau.javamyblogapi.mapper.ArticlesContentsMapper;
import com.weylau.javamyblogapi.mapper.ArticlesMapper;
import com.weylau.javamyblogapi.request.front.ArticleDetailRequest;
import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.front.ArticleDetailResponse;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import com.weylau.javamyblogapi.service.front.MqService;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MqServiceImpl implements MqService {
    public final Logger logger = LoggerFactory.getLogger(MqServiceImpl.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void send(String msg) {
        String msgId = UUID.randomUUID().toString();
        CorrelationData correlationData = new CorrelationData(msgId);
        rabbitTemplate.convertAndSend(RabbitConfig.MAIL_EXCHANGE_NAME, RabbitConfig.MAIL_ROUTING_KEY_NAME, msg, correlationData);// 发送消息
    }

    @RabbitListener(queues = RabbitConfig.MAIL_QUEUE_NAME)
    public void consume(Message message, Channel channel) throws IOException {
        logger.info("收到消息: {}", message.toString());

        MessageProperties properties = message.getMessageProperties();
        long tag = properties.getDeliveryTag();
//        channel.basicAck(tag, false);// 消费确认
        channel.basicNack(tag, false, true);//非确认消息：最后一个参数 requeue 设置为true 会把消费失败的消息从新添加到队列的尾端，设置为false不会重新回到队列
    }

}
