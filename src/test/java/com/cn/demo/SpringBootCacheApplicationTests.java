package com.cn.demo;

import com.cn.demo.entity.Employees;
import com.cn.demo.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBootCacheApplicationTests {

//    @Autowired
//    EmployeeMapper employeeMapper;
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;    // 操作的 k-v 都是字符串
//
//    @Autowired
//    RedisTemplate<Object, Object> redisTemplate;
//
//    @Test
//    public void test01() {
//        // 向Redis中保存数据
//        stringRedisTemplate.opsForValue().append("msg", "Hello World");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
//    }
//
//    @Test
//    public void test02() {
//        Employees employees = employeeMapper.getEmpById(1);
//        System.out.println(employees);
//        redisTemplate.opsForValue().set("emp", employees);
//    }

    //    测试RabbitMQ消息中间件
    @Autowired
    RabbitTemplate rabbitTemplate;

    //  测试发送消息到RabbitMQ的队列中
    @Test
    public void sendMessage() {
        //  Message需要自己构造一个，定义消息体内容和消息头
        //  rabbitTemplate.send(exchange,routkey,object)

        // object默认为消息体，只需要传入要发送的对象，自动序列化发送给RabbitMQ
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", "Hello World");
        // 对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "message.news", map);
    }

    //    测试从RabbitMQ的队列中接收数据
    @Test
    public void receiveMessage() {

        Object o = rabbitTemplate.receiveAndConvert("message");
        System.out.println(o.getClass());
        System.out.println(o.toString());
        System.out.println(o);

    }

    // 使用AmqpAdmin组件来实现RabbitMQ的Queue、Excahnge、Binding的创建和删除
    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExcahnge() {
        //  创建Direct型的 Exchange 以及设置它的参数
        amqpAdmin.declareExchange(new DirectExchange("test.direct", true, true));
        //  创建Fanout型的 Exchange 以及设置它的参数
        amqpAdmin.declareExchange(new FanoutExchange("test.fanout", true, true));
        //  创建Topic型的 Exchange 以及设置它的参数
        amqpAdmin.declareExchange(new TopicExchange("test.topuc", true, true));

        //  创建队列Queue
        amqpAdmin.declareQueue(new Queue("queue", true));
        amqpAdmin.declareQueue(new Queue("queue.bo"));
        amqpAdmin.declareQueue(new Queue("queue.test"));
        amqpAdmin.declareQueue(new Queue("test.bo"));

        //  设置绑定关系
        //  destination：目的地-绑定目标，Binding.DestinationType：绑定对象，exchange：需要绑定的交换机，routitngkey：路由键，arguments：其他参数（map类型）
        amqpAdmin.declareBinding(new Binding("queue", Binding.DestinationType.QUEUE, "test.direct", "queue", null));
    }
}
