package cn.itcast.gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyFilter implements GlobalFilter, Ordered {

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //获取请求参数access-token
        String token = exchange.getRequest().getQueryParams().getFirst("access-token");
        //如果不存在
        if(token == null){
            System.out.println("未认证");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED); //返回提示状态码
            return exchange.getResponse().setComplete();//请求结束
        }
        //如果存在，继续往下执行
        return chain.filter(exchange);
    }


    /**
     * 自定过滤器执行顺序
     * @return 返回值越小优先级越高
     */
    public int getOrder() {
        return 0;
    }
}
