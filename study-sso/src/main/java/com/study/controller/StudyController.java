package com.study.controller;


import com.study.config.RedisCache;
import com.study.test.Father;
import com.study.test.boy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/sso")
public class StudyController {

    @Autowired
    private RedisCache redisCache;

    @GetMapping("/redisTest")
    public String redisTest(){
        redisCache.setCacheObject("aaa","bbb");
        Occupation doc = Occupation.Doc;
        String value = doc.getValue();
        Father a=new boy();
        a.test2();
        return value;

    }

    private final static String kafakaTopic="testKafka";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/sendKafka")
    public void sendKafka(@RequestBody String data){
        kafkaTemplate.send(kafakaTopic,data);
    }

    @KafkaListener(topics = kafakaTopic,groupId = "studyGroup")
    public void kafkaListen(String data,Acknowledgment ack){
        System.out.println("消息为: "+data);
        ack.acknowledge();
    }

    @GetMapping("/thread")
    public String threadTest(){

        ReentrantLock reentrantLock = new ReentrantLock(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    quQian();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    quQian();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"线程2").start();


        return null;

    }


    public synchronized void quQian() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"取钱中");
        Thread.sleep(3000L);

        HashSet<String> strings = new HashSet<>();

        System.out.println(Thread.currentThread().getName()+"取完了");
    }

}
