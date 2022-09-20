package cn.itcast.order.service;

import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    //@Autowired
    //private RestTemplate restTemplate;

    @Autowired
    private UserClient userClient;



    public Order queryOrderById(Long orderId) {

        // 1.查询订单
        Order order = orderMapper.findById(orderId);

        /**
        //2.利用RestTemplate发起http请求，查询user信息
        //2.1 url路径
        //String url = "http://localhost:8081/user/"+order.getUserId(); //硬编码，修改端口时需要修改service层的代码
         String url = "http://user-service/user/"+order.getUserId();//使用restTemplate远程调用
        //2.2 发起http请求，实现远程调用
        User user = restTemplate.getForObject(url, User.class);
         */

        //2.用feign远程调用
        User user = userClient.findById(order.getUserId());
        //3.封装user
        order.setUser(user);
        // 4.返回
        return order;

    }
}
