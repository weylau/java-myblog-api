package com.weylau.javamyblogapi.controller.front;

import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.request.admin.DetailParams;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

@RestController
public class ArticlesController extends BaseController{
    final static Logger logger = LoggerFactory.getLogger(ArticlesController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    ArticlesService articlesService;

    /**
     * 获取文章列表
     *
     * @return
     */
    @GetMapping(value = "/articles", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Response list(
            @RequestParam(value = "page", defaultValue = "1", required = false) Integer page,
            @RequestParam(value = "page_size", defaultValue = "20", required = false) Integer page_size,
            @RequestParam(value = "cate_id", defaultValue = "0", required = false) Integer cate_id
    ) {
        return articlesService.getList(page, page_size, cate_id);
    }

    /**
     * 获取文章详情
     *
     * @return
     */
    @GetMapping("/article/{id}")
    public Response detail(
            @Valid DetailParams detailParams
    ) {
        return articlesService.detail(detailParams.getId());
    }
    /**
     * 发送既忘方式（异步发送）
     *
     * @return
     */
    @GetMapping("/send01")
    public void send01(){
        kafkaTemplate.send("truck_cos_topic", "send01");
        return;
    }

    /**
     * 异步发送 带回调
     */
    @GetMapping("/send02")
    public void send02(){
        kafkaTemplate.send("test_topic", "send02").addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("msg send fail！ exception ： "+ throwable.getMessage());  //失败回调
            }

            @Override
            public void onSuccess(SendResult<String,String> sendMessage) {
                logger.info("send success topic:{} msg:{}",sendMessage.getProducerRecord().topic(), sendMessage.getProducerRecord().value());
            }
        });
        return;
    }

    /**
     * 同步发送
     */
    @GetMapping("/send03")
    public void send03(){
        try {
            SendResult<String, String> sendResult = (SendResult<String, String>) kafkaTemplate.send("test_topic", "send03").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return;
    }

    /**
     * 事务发送
     */
    @GetMapping("/send04")
    @Transactional
    public void send04(){
        kafkaTemplate.send("test_topic", "send04").addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                logger.info("msg send fail！ exception ： "+ throwable.getMessage());  //失败回调
            }

            @Override
            public void onSuccess(SendResult<String,String> sendMessage) {
                logger.info("send success topic:{} msg:{}",sendMessage.getProducerRecord().topic(), sendMessage.getProducerRecord().value());
            }
        });
        return;
    }
}
