package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.stereotype.Component;

//声明为一个bean
@Component
public class UserClientCallBack implements UserClient{

    /**
     * 熔断降级的方法
     */
    public User findById(Long id) {
        User user = new User();
        user.setUsername("feign调用的熔断降级方法");
        return user;
    }
}
