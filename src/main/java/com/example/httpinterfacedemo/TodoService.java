package com.example.httpinterfacedemo;

import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface TodoService {
    @GetExchange("/todos")
    List<TodoResponse> getTodos();
}
