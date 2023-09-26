package com.example.httpinterfacedemo.beans;

import com.example.httpinterfacedemo.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.core.publisher.Mono;

@Component
public class TodoServiceBean {
    @Bean("todoServiceImpl")
    TodoService todoService() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .defaultStatusHandler(HttpStatusCode::is4xxClientError, resp -> {
                    System.out.println("Hello, error!");
                    return Mono.just(new RuntimeException("It's HTTP Error!"));
                })
                .build();

        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                .build();

        return httpServiceProxyFactory.createClient(TodoService.class);
    }
}
