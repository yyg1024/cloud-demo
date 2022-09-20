package cn.itcast.order.clients;

import cn.itcast.order.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 声明需要调用的微服务名称
 * @FeignClient
 *       *name：服务提供者
 *       *fallback：配置熔断发生降级方法实现类
 */
@FeignClient(name = "user-service",fallback = UserClientCallBack.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
